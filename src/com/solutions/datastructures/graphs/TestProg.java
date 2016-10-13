package com.solutions.datastructures.graphs;

/**
 * Created by ADMIN-COOLUCAN on 10/12/2016.
 */
public class TestProg {

    public static void main(String[] args) {
        /*1.
        Graph g = new GraphAdjacencyList(6,true);
        Graph g = new GraphAdjacencyMatrix(6,true);
        g.addEdge(3,5,10);
        g.addEdge(1,4,6);
        g.addEdge(3,2,1);
        g.addEdge(1,5,10);
        g.addEdge(2,5,10);
        g.addEdge(3,4,10);
        g.addEdge(4,1,10);
        g.display();*/

        Graph g = new GraphAdjacencyMatrix(10,true);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(3,6);
        g.addEdge(4,7);
        g.addEdge(8,9);

        g.display();
        g.breadthFirstTraversal();
        System.out.println();
        g.depthFirstTraversal();


    }
}
