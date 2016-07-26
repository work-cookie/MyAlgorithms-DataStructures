package com.solutions.datastructures.stacks;

/**
 * Created by chch0316 on 7/26/2016.
 */
public class StackNode<T> {
        T data;
        StackNode<T> next;
        public StackNode(T data){
            this.data=data;
        }
}
