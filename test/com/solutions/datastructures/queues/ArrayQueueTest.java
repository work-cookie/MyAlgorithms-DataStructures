package test.com.solutions.datastructures.queues;

import com.solutions.datastructures.queues.ArrayQueue;
import com.solutions.datastructures.queues.Queue;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by chch0316 on 7/25/2016.
 */
public class ArrayQueueTest {

    @org.junit.Test
    public void testEnQueue() throws Exception {
        Queue<Integer> aq = new ArrayQueue<Integer>();
        aq.enQueue(10);
        aq.enQueue(30);
        aq.enQueue(70);
        Assert.assertEquals(3,aq.size());
        Assert.assertEquals("10\t30\t\70\t",aq.toString());
    }

    @org.junit.Test
    public void testDeQueue() throws Exception {

    }

    @org.junit.Test
    public void testPeek() throws Exception {

    }

    @org.junit.Test
    public void testToString() throws Exception {

    }
}