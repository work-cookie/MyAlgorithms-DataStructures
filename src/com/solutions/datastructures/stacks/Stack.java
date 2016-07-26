package com.solutions.datastructures.stacks;

/**
 * Created by chch0316 on 7/26/2016.
 */
public interface Stack <T>{

    void push(T newEle);
    T pop() throws StackException;
    T peek() throws StackException;
    int size();
    String toString();
    boolean isEmpty();
}
