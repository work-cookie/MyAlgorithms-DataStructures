package com.solutions.datastructures.graphs;

/**
 * Created by ADMIN-COOLUCAN on 10/12/2016.
 */
public class TestProg {

    public static void main(String[] args) {
        //Graph g = new GraphAdjacencyList(6,true);
        Graph g = new GraphAdjacencyMatrix(6,true);
        g.addEdge(3,5,10);
        g.addEdge(1,4,6);
        g.addEdge(3,2,1);
        g.addEdge(1,5,10);
        g.addEdge(2,5,10);
        g.addEdge(3,4,10);
        g.addEdge(4,1,10);
        g.display();

    }
}
