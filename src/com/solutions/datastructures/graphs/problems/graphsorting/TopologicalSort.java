package com.solutions.datastructures.graphs.problems.graphsorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ADMIN-COOLUCAN on 10/18/2016.
 */
public class TopologicalSort {

    public Project[] topSortProjects(ArrayList<Project> projects){
        Project[] order = new Project[projects.size()];

        //1. Finding Non-dependent nodes
        int endOfOrder = addNonDependent(order, projects, 0);

        int toBeProcessed =0;
        while(toBeProcessed < order.length){
            Project proj = order[toBeProcessed];

            //No Zero incoming edge node i.e. Circular way of nodes in Graph. So Sorting is not possible.
            if(proj==null){
                return null;
            }
            //Removing self dependency
            ArrayList<Project> children = proj.getChildren();
            for (Project p:children   ) {
                p.decrementDependencies();
            }
            //Again finding Non-deoendent nodes
            endOfOrder = addNonDependent(order,children,endOfOrder);
            toBeProcessed++;
        }

        return order;
    }

    private int addNonDependent(Project[] order,ArrayList<Project> projects, int endOfOrder){
        for (Project p : projects  ) {
            if(p.getNoOfDependencies()==0){
                order[endOfOrder++]= p;
            }
        }
        return endOfOrder;
    }

    public Stack<Project> DFStopSortProjects(ArrayList<Project> projects){
        Stack<Project> stack = new Stack<Project>();
        for (Project proj: projects  ) {
            if(proj.getState()== Project.State.BLANK){
                if(!doDFS(proj,stack))
                    return null;
            }
        }
        return stack;
    }

    private boolean doDFS(Project project, Stack<Project> st){
        if(project.getState()== Project.State.PARTIAL)
            return false;
        if(project.getState()== Project.State.BLANK){
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for (Project proj: children ) {
                if(!doDFS(proj,st))
                    return false;
            }
            project.setState(Project.State.COMPLETED);
            st.push(project);
        }
        return true;
    }
}
