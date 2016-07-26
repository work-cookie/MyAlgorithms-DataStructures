package com.solutions.datastructures.queues;

/**
 * Created by chch0316 on 7/25/2016.
 */
public interface Queue<T> {

    void enQueue(T newItem);
    boolean isEmpty();
    T deQueue() throws QueueException;
    String toString();
    T peek() throws QueueException;
    int size();
}
