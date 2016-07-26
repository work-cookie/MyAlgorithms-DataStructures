package com.solutions.datastructures.stacks;

/**
 * Created by chch0316 on 7/26/2016.
 */

public class LinkedStack<T> implements Stack {

    StackNode<T> head;
    int size;
    public LinkedStack(){
        head=null;
        size=0;
    }
    @Override
    public void push(Object newEle) {
        StackNode x= new StackNode(newEle);
        if(size()==0){
            head = x;
        }else{
            x.next =head;
            head=x;
        }
        ++size;
    }

    @Override
    public Object pop() throws StackException {
        if(size()==0)
            return new StackException("Stack: No element found to POP");
        StackNode x = head;
        head =head.next;
        --size;
        return x.data;
    }

    @Override
    public Object peek() throws StackException {
        if(size()==0)
            return new StackException("Stack: No element found to peek");
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s="";
        StackNode current = head;
        while (current!=null){
            s += current.data+"\t";
            current=current.next;
        }
        return s;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
