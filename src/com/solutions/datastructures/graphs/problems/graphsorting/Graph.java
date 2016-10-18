package com.solutions.datastructures.graphs.problems.graphsorting;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ADMIN-COOLUCAN on 10/18/2016.
 */
public class Graph<T> {
    private ArrayList<Project<T>> nodes;
    private HashMap<T,Project<T>> map;
    private int noOfNodes;

    Graph(){
        nodes = new ArrayList<Project<T>>();
        map = new HashMap<T, Project<T>>();
        noOfNodes=0;
    }

    public Project<T> getOrCreateNode(T name){
        if(!map.containsKey(name)){
            Project<T> node = new Project<T>(name);
            map.put(name,node);
            nodes.add(node);
            noOfNodes++;
        }
        return map.get(name);
    }

    public void addEdge(T startName,T endName){
        Project<T> start = getOrCreateNode(startName);
        Project<T> end = getOrCreateNode(endName);
        start.addNeighbour(end);
    }
    public ArrayList<Project<T>> getNodes(){return nodes;}

    public int getNoOfNodes(){return noOfNodes;}

}
