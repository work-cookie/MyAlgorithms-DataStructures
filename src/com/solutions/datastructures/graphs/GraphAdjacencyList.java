package com.solutions.datastructures.graphs;

import com.solutions.datastructures.queues.*;
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.Queue;

/**
 * Created by chch0316 on 8/27/2016.
 */
class Vertex{
    Vertex next;
    Integer vertexNo;
    Integer weight;
    Vertex(int vertexNo, int weight){
        this.vertexNo = vertexNo;
        this.weight = weight;
        next=null;
    }
}
public class GraphAdjacencyList {
    int noOfVertices;
    HashMap<Integer,LinkedList<Vertex>> edjList ;

    GraphAdjacencyList(int noOfVertices){
        this.noOfVertices = noOfVertices;
        edjList = new HashMap<Integer, LinkedList<Vertex>>();

        for (int i = 1; i <= noOfVertices ; i++) {
            edjList.put(i,new LinkedList<Vertex>());
        }
    }

    void addEdge(int source,int dest,int weight){
        if(edjList.get(source)==null|| edjList.get(dest)==null)
            return;
        Vertex x= new Vertex(dest, weight);
        edjList.get(source).add(x);

        Vertex y= new Vertex(source, weight);
        edjList.get(dest).add(y);
    }

    void addVertex(int vertex){
        if(edjList.get(vertex)!=null)
            return;
        noOfVertices++;
        edjList.put(vertex,new LinkedList<Vertex>());
    }

    List<Vertex> getAdjacentVertices(int source){
        return edjList.get(source);
    }

    boolean areConnected(int source, int dest){
        List<Vertex> list = edjList.get(source);
        Iterator<Vertex> itr = list.iterator();
        while (itr.hasNext()){
            if(itr.next().vertexNo == dest)
                return true;
        }
        return false;
    }

    void displayGraph(){
        Set<Map.Entry<Integer,LinkedList<Vertex>>> set= edjList.entrySet();
        for (Map.Entry<Integer,LinkedList<Vertex>> entry: set) {
            int vertex =entry.getKey();
            LinkedList list = entry.getValue();
            Iterator<Vertex> itr = list.iterator();
            System.out.println("Vertext No: "+ vertex);
            while (itr.hasNext()){
                Vertex x= itr.next();
                System.out.print("("+x.vertexNo+" , "+x.weight+" ) -> ");
            }
            System.out.println(" Null");
        }
    }

    void breadthFirstTraversal(){
       boolean[] visit = new boolean[noOfVertices];
        for (int i = 1; i <= noOfVertices ; i++) {
            if(visit[i-1]==false)
                aux_breadthFirst(i,visit);
        }
    }
    void aux_breadthFirst(int vNo, boolean[] visit){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(vNo);
        visit[vNo-1]= true;
        while (!queue.isEmpty()){
            int x= queue.poll();
            System.out.print(x+" -> ");
            Iterator<Vertex> itr = edjList.get(x).iterator();
            while (itr.hasNext()){
               Vertex v = itr.next();
                if(visit[v.vertexNo-1]==false) {
                    queue.add(v.vertexNo);
                    visit[v.vertexNo-1]= true;
                }
            }
        }
    }

    void depthFirstTraversal(){
        System.out.println();
        boolean[] visit = new boolean[noOfVertices];
        for (int i = 1; i <= noOfVertices ; i++) {
            if(visit[i-1]==false)
                aux_depthFirst(i,visit);
        }
    }

    void aux_depthFirst(int vNo,boolean[] visit){
        System.out.print(vNo+" -> ");
        visit[vNo-1]=true;
        Iterator<Vertex> itr = edjList.get(vNo).iterator();
        while (itr.hasNext()){
            Vertex x= itr.next();
            if(visit[x.vertexNo-1]==false)
                aux_depthFirst(x.vertexNo,visit);
        }
    }

    public static void main(String[] args) {

        GraphAdjacencyList graph = new GraphAdjacencyList(7);
        graph.addEdge(1,3,10);
        graph.addEdge(1,6,4);
        graph.addEdge(6,4,6);
        graph.addEdge(4,5,8);
        graph.addEdge(4,2,12);
        graph.addVertex(8);
        graph.addEdge(5,8,7);

        graph.displayGraph();
        graph.breadthFirstTraversal();
        graph.depthFirstTraversal();

        System.out.println("Is edge there : "+ graph.areConnected(5,8));

    }

}
