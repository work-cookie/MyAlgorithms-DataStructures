package com.solutions.datastructures.graphs;

import java.util.*;

/**
 * Created by ADMIN-COOLUCAN on 10/12/2016.
 */
public class GraphAdjacencyMatrix implements Graph{

    private boolean isDirected;
    private Integer noOfVertices;
    private Integer noOfEdges;
    private Integer [][] adjMat;
    private Integer[][] weightMat;

    GraphAdjacencyMatrix(){
        adjMat = new Integer[10][10];
        noOfEdges =0;
    }

    GraphAdjacencyMatrix(Integer noOfVertices,boolean isDirected){
        noOfEdges =0;
        this.noOfVertices = noOfVertices;
        this.isDirected = isDirected;
        adjMat = new Integer[noOfVertices][noOfVertices];
        weightMat = new Integer[noOfVertices][noOfVertices];
        for (int i = 0; i < noOfVertices ; i++) {
            for (int j = 0; j < noOfVertices ; j++) {
                adjMat[i][j] =0;
                weightMat[i][j]=0;
            }
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

    }

    @Override
    public void addEdge(Integer source, Integer dest) {
        if(source >= noOfVertices || dest >= noOfVertices)
            return;
        adjMat[source][dest] =1;
        ++noOfEdges;
        if(!isDirected) {
            adjMat[dest][source]=1;
            ++noOfEdges;
        }
    }

    @Override
    public void addEdge(Integer source, Integer dest, Integer weight) {
        if(source >= noOfVertices || dest >= noOfVertices)
            return;
        addEdge(source,dest);
        weightMat[source][dest]= weight;
        if(!isDirected)
            weightMat[dest][source] = weight;
    }

    @Override
    public void display() {
        System.out.print("x : ");
        for (int i = 0; i < noOfVertices ; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < noOfVertices ; i++) {
            System.out.print(i+ " : ");
            for (int j = 0; j < noOfVertices; j++) {
                System.out.print(adjMat[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Override
    public Iterator getVertices() {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i <noOfVertices ; i++) {
            list.add(i);
        }
        return list.iterator();
    }

    @Override
    public boolean areConnected(Integer source, Integer dest) {
        if(source>= noOfVertices || dest >= noOfVertices)
            return false;
        return adjMat[source][dest]==1;
    }

    @Override
    public List getConnectedVertices(Integer source) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i <noOfVertices ; i++) {
            if(adjMat[source][i]==1)
                list.add(i);
        }
        return list;
    }

    @Override
    public void breadthFirstTraversal() {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < noOfVertices ; i++) {
            if(visited[i]==false){
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(i);
                visited[i]=true;
                while (!q.isEmpty()){
                    Integer x = q.poll();
                    System.out.print(x+"->");
                    for (int j = 0; j < noOfVertices ; j++) {
                        if(adjMat[x][j]==1 && visited[j]==false) {
                            q.add(j);
                            visited[j]=true;
                        }

                    }
                }
            }
        }
    }

    @Override
    public void depthFirstTraversal() {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < noOfVertices ; i++) {
            if(visited[i]==false){
                Stack<Integer> q = new Stack<Integer>();
                q.add(i);
                visited[i]=true;
                while (!q.isEmpty()){
                    Integer x = q.pop();
                    visited[i]=true;
                    System.out.print(x+"->");
                    for (int j = 0; j < noOfVertices ; j++) {
                        if(adjMat[x][j]==1 && visited[j]==false) {
                            q.add(j);
                            visited[j]=true;
                        }
                    }
                }
            }
        }
    }
}
