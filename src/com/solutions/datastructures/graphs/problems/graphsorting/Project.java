package com.solutions.datastructures.graphs.problems.graphsorting;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ADMIN-COOLUCAN on 10/18/2016.
 */
public class Project<T> {
    private T name;
    private ArrayList<Project<T>> children;
    private HashMap<T, Project<T>> map;
    private int noOfDependencies;

    Project(T name){
        this.name = name;
        children = new ArrayList<Project<T>>();
        map = new HashMap<T, Project<T>>();
        noOfDependencies=0;
    }

    public T getName(){return name;}
    public ArrayList<Project<T>> getChildren(){ return children;}
    public int getNoOfDependencies(){return noOfDependencies;};

    public void incrementDependencies(){noOfDependencies++;}
    public void decrementDependencies(){noOfDependencies--;};

    void addNeighbour(Project<T> node){
        if(map.containsKey(node.getName()))
            return;
        children.add(node);
        map.put(node.getName(),node);
        node.incrementDependencies();
    }
}
