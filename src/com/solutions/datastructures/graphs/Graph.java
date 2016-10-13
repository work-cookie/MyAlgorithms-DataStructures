package com.solutions.datastructures.graphs;

import java.util.Iterator;
import java.util.List;

/**
 * Created by chch0316 on 10/12/2016.
 */
public interface Graph {

    boolean isDirected();
    Integer noOfVertices();
    Integer noOfEdges();
    void addVertex(Integer vertexNo);
    void addEdge(Integer source, Integer dest);
    void addEdge(Integer source, Integer dest, Integer weight);
    void display();
    Iterator getVertices();
    boolean areConnected(Integer source, Integer dest);
    List getConnectedVertices(Integer source);
    void breadthFirstTraversal();
    void depthFirstTraversal();
}
