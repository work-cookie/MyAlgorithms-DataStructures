package com.solutions.datastructures.graphs.problems.graphsorting;

import java.util.Stack;

/**
 * Created by chch0316 on 10/18/2016.
 */
public class TestDriver {

    public static Project[] findBuildOrder(String[] projects, String[][] dependencies){
        Graph graph = buildGraph(projects,dependencies);
        return new TopologicalSort().topSortProjects(graph.getNodes());
    }

    public static Graph buildGraph(String[] projects, String[][] dependencies){
        Graph<String> g = new Graph<String>();
        for (String proj:projects ) {
            g.getOrCreateNode(proj);
        }

        for (String[] edge: dependencies ) {
            g.addEdge(edge[0] , edge[1]);
        }
        return g;
    }

    public static Stack<Project> findBuildOrderDFS(String[] projects, String[][] dependencies){
        Graph graph = buildGraph(projects,dependencies);
        return new TopologicalSort().DFStopSortProjects(graph.getNodes());
    }

    public static void main(String[] args) {

        String[] projects = {"H","I","J","K","A","B","C","D","E","F","G","L","M","N"};
        String[][] dependencies = {{"F","B"},{"F","D"},{"F","H"},{"H","D"},{"B","D"},{"D","A"},
                {"G","A"},{"G","E"},{"G","J"},{"A","J"},{"E","J"},{"J","I"},{"I","C"},{"L","K"},{"K","M"},{"K","N"}};
        Project[] order = findBuildOrder(projects,dependencies);

        for (int i = 0; i < order.length ; i++) {
            System.out.print(order[i]+"->");
        }
        System.out.println();

        Stack<Project> stack = findBuildOrderDFS(projects,dependencies);
        while(stack.size() >0){
            System.out.print(stack.pop()+"->");
        }


    }
}
