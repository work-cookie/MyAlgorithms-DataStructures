package test.com.solutions.datastructures.queues;

import com.solutions.datastructures.queues.ArrayQueue;
import com.solutions.datastructures.queues.Queue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chch0316 on 7/25/2016.
 */
public class ArrayQueueTest {

    Queue<Integer> q;

    @Before
    public void before(){
        System.out.println("Before");
        q = new ArrayQueue<Integer>();
        q.enQueue(10);
        q.enQueue(30);
        q.enQueue(70);
    }

    @org.junit.Test
    public void testEnQueue() throws Exception {
        Assert.assertEquals(3,q.size());
        Assert.assertEquals("10\t30\t70",q.toString().trim());
    }
    @org.junit.Test
    public void testDeQueue() throws Exception {
        q.deQueue();
        System.out.println(q.toString());
        q.deQueue();
        Assert.assertEquals(1,q.size());
        Assert.assertEquals("70",q.toString().trim());
    }
    @org.junit.Test
    public void testPeek() throws Exception {
        System.out.println(q.toString());
        q.enQueue(50);
        Assert.assertEquals(4,q.size());
        Assert.assertEquals(Integer.valueOf(10),q.peek());
    }

    @org.junit.Test
    public void testToString() throws Exception {

    }
    @After
    public void after(){
        q=null;
    }

    @Test
    public void main(){
        Queue<Integer>q = new ArrayQueue<Integer>();
        q.enQueue(150);
        q.enQueue(100);
        q.enQueue(450);
        q.enQueue(120);
        q.enQueue(150);
        q.enQueue(100);
        q.enQueue(450);
        q.enQueue(120);
        q.enQueue(150);
        q.enQueue(100);
        q.enQueue(450);
        q.enQueue(120);
        System.out.println(q.toString());
        q.deQueue();
        q.deQueue();
        System.out.println("After deletion: "+q.toString());
        System.out.println("Peek is : "+q.peek());
    }
}