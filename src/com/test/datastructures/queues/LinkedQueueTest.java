package com.test.datastructures.queues;

import com.solutions.datastructures.queues.LinkedQueue;
import com.solutions.datastructures.queues.Queue;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ADMIN-COOLUCAN on 7/26/2016.
 */
public class LinkedQueueTest {

    @Test
    public static void main(String[] args){
        Queue<Integer> q= new LinkedQueue<Integer>();
        q.enQueue(10);
        q.enQueue(50);
        System.out.println(q);
        q.enQueue(70);
        q.enQueue(30);
        System.out.println(q);

        System.out.println("Removing ele: "+q.deQueue());
        System.out.println(q);
        System.out.println("Peek ele: "+q.peek());

        Assert.assertEquals(3,q.size());
        Assert.assertFalse(q.isEmpty());
        System.out.println(q);
    }

}