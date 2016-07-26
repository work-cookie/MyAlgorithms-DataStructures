package com.solutions.datastructures.queues;

/**
 * Created by ADMIN-COOLUCAN on 7/26/2016.
 */
class ListNode<T>{
    ListNode next;
    T data;
    public ListNode(T data) {
        this.data = data;
        next=null;
    }
}
public class LinkedQueue<T> implements Queue {

    ListNode<T> head,tail;
    int size;

    public LinkedQueue() {
        size =0;
        head=tail=null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enQueue(Object newItem) {
        ListNode item = new ListNode(newItem);
        if(size==0){
            head= item;
            tail=item;
            ++size;
            return;
        }
        tail.next = item;
        tail=item;
        ++size;
    }

    @Override
    public Object deQueue() throws QueueException {
        if(size==0)
            return new QueueException("Queue: Trying to delete from Empty Queue.");
        ListNode x= head;
        head= head.next;
        if(--size==0)
            tail=null;
        return x.data;
    }

    @Override
    public Object peek() throws QueueException {
        if(size==0)
            return new QueueException("Queue: Trying to delete from Empty Queue.");
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public String toString() {
        String s= "";
        ListNode current = head;
        while (current!=null){
            s += current.data+"\t";
            current=current.next;
        }
        return s;
    }
}
