package com.solutions.datastructures.queues;

import java.util.Arrays;

/**
 * Created by chch0316 on 7/25/2016.
 */
/*
 Queue (FIFO) implmentation- using circular Array
 */
public class ArrayQueue<T> implements Queue {

    private T[] items;
    private int size;
    private int capacity;
    private int front;
    private int rear;

    public ArrayQueue(){
        this(10);
    }
    public ArrayQueue(int capacity){
        this.capacity = capacity;
        items = (T[])new Object[capacity];
        front=rear=0;
        size=0;
    }

    @Override
    public void enQueue(Object newItem) {
        if(size==capacity){
            T[] newItems = (T[]) new Object[2*capacity];
            int x= front;
            for (int i = 0; i <size ; i++) {
                newItems[i]= items[x%capacity];
                x++;
            }
            front=0;
            items = newItems;
            capacity = 2*capacity;
        }
        items[rear++%capacity] = (T)newItem;
        ++size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public Object deQueue() throws QueueException {
        if(!isEmpty()){
            size--;
            return items[front++%capacity];
        }
        else {
            return new QueueException("Queue: Trying to delete from empty Queue.");
        }
    }

    @Override
    public Object peek() throws QueueException{
        if(!isEmpty())
            return items[front++%capacity];
        else
            return new QueueException("Queue: Trying to get value from empty Queue.");
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        String s="";
        int x = front;
        for (int i = 0; i < size; i++) {
            x= x % capacity;
            s += items[x]+"\t";
            x++;
        }
        return s;
    }
}
