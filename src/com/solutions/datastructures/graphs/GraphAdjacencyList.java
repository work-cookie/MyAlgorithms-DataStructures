package com.solutions.datastructures.graphs;

import com.solutions.datastructures.lists.*;

import java.util.*;
import java.util.List;

/**
 * Created by chch0316 on 10/12/2016.
 */
public class GraphAdjacencyList implements Graph {

    private boolean isDirected;
    private Integer noOfVertices;
    private Integer noOfEdges;
    HashMap<Integer,LinkedList<Vertex>> adjList;

    class Vertex {
        Integer vertexNo;
        Integer edgeWeight;
        Vertex(Integer vertexNo){
            this.vertexNo = vertexNo;
        }
        Vertex(Integer vertexNo,Integer edgeWeight){
            this(vertexNo);
            this.edgeWeight = edgeWeight;
        }
    }

    GraphAdjacencyList(){
        adjList = new HashMap<Integer, LinkedList<Vertex>>();
        noOfEdges =0;
    }

    GraphAdjacencyList(Integer noOfVertices,boolean isDirected){
        this();
        this.noOfVertices = noOfVertices;
        this.isDirected = isDirected;

        for (int i = 0; i < noOfVertices ; i++) {
            adjList.put(i,new LinkedList<Vertex>());
        }
    }

    @Override
    public boolean isDirected() {
        return isDirected;
    }

    @Override
    public Integer noOfVertices() {
        return noOfVertices;
    }

    @Override
    public Integer noOfEdges() {
        return noOfEdges;
    }

    @Override
    public void addVertex(Integer vertexNo) {
        if(adjList.get(vertexNo)!=null)
            return;
        adjList.put(vertexNo,new LinkedList<Vertex>());
        ++noOfVertices;
    }

    @Override
    public void addEdge(Integer source, Integer dest) {
        if(adjList.get(source)==null || adjList.get(dest)==null)
            return;
        ++noOfEdges;
        adjList.get(source).add(new Vertex(dest));
        if(!isDirected){
            adjList.get(dest).add(new Vertex(source));
            ++noOfEdges;
        }
    }

    @Override
    public void addEdge(Integer source, Integer dest, Integer weight) {
        if(adjList.get(source)==null || adjList.get(dest)==null)
            return;
        ++noOfEdges;
        adjList.get(source).add(new Vertex(dest,weight));
        if(!isDirected){
            adjList.get(dest).add(new Vertex(source,weight));
            ++noOfEdges;
        }
    }

    @Override
    public Iterator getVertices() {
        return adjList.keySet().iterator();
    }

    @Override
    public void display() {
       Set <Map.Entry<Integer,LinkedList<Vertex>>> entrySet = adjList.entrySet();
        for (Map.Entry<Integer,LinkedList<Vertex>> entry : entrySet ) {
            System.out.print(entry.getKey()+" : ");
            Iterator<Vertex> itr = entry.getValue().iterator();
            while (itr.hasNext()){
                Vertex temp = itr.next();
                System.out.print("("+temp.vertexNo+","+temp.edgeWeight+")->");
            }
            System.out.println();
        }
    }

    @Override
    public boolean areConnected(Integer source, Integer dest) {
        List<Vertex> list;
        Integer key;
        if(adjList.get(source).size() > adjList.get(dest).size()) {
            list = adjList.get(dest);
            key = source;
        }
        else {
            list = adjList.get(source);
            key= dest;
        }

        Iterator<Vertex> itr = list.iterator();
        while (itr.hasNext()){
            Vertex temp = itr.next();
            if(temp.vertexNo == key){
                return true;
            }
        }
        return false;
    }

    @Override
    public List getConnectedVertices(Integer source) {
        return adjList.get(source);
    }
}
