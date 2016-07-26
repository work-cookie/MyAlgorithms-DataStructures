package com.solutions.datastructures.queues.problems;

import com.solutions.datastructures.queues.Queue;
import com.solutions.datastructures.queues.QueueException;
import com.solutions.datastructures.stacks.LinkedStack;
import com.solutions.datastructures.stacks.Stack;

import com.solutions.datastructures.stacks.StackNode;

/**
 * Created by chch0316 on 7/26/2016.
 */
/*  Queue Implementation - Using two Stacks
    Way 1:
        for every (element x) insert into st1
        a) copy all elements of st1 to st2
        b) st1.push(x)
        c) copy all elements of st2 to st1
        So that the pop() element should be at the top of the st1
         enQueue -- O(n) requires = 2n moves && deQueue -- O(1)

    Way 2: (Better Approach)
        a) push x into st1
        b) pop()
            if(st1 is empty && st2 is empty)
                return error
            if(st2 is empty)
                pop all elements of st1 to st2 and pop of st2
            else
                pop from st2
         So that pop() element should comes from st2.
         enQueue -- O(1) && deQueue -- O(n) ( if st2 is empty only)

     Either, any one of the operation requires n moves.

    Way 3: Using one user Stack + Function call Stack

 */
public class QueueUsingStacks <T> implements Queue{

    Stack<T> st1,st2;
    int size;
    public QueueUsingStacks(){
        st1= new LinkedStack<T>();
        st2= new LinkedStack<T>();
        size=0;
    }

    @Override
    public void enQueue(Object newItem) {
        st1.push((T)newItem);
        ++size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    //Way 2:
    public Object deQueue1() throws QueueException {
        if(isEmpty())
            return new QueueException("Queue: No element found to delete");
        if(st2.isEmpty()){
            while (!st1.isEmpty()){
                st2.push((T)st1.pop());
            }
        }
        size--;
        return st2.pop();
    }

    // Way 3:
    @Override
    public Object deQueue() throws QueueException {
        if(isEmpty())
            return new QueueException("Queue: No element found to delete");
        Object x=auxDeQueue();
        size--;
        return x;
    }

    private Object auxDeQueue() throws QueueException{
        if(st1.size()==1)
            return st1.pop();
        Object x = st1.pop();
        Object res = auxDeQueue();
        st1.push((T)x);
        return res;
    }


    @Override
    public Object peek() throws QueueException {
        if(isEmpty())
            return new QueueException("Queue: No element found");
        if(st2.isEmpty()){
            while (!st1.isEmpty()){
                st2.push((T)st1.pop());
            }
        }
        return st2.peek();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        System.out.println(st2);
        System.out.println(st1);
        return "";
    }
}
