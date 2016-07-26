package test.com.solutions.datastructures.queues.problems;

import com.solutions.datastructures.queues.Queue;
import com.solutions.datastructures.queues.problems.QueueUsingStacks;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by chch0316 on 7/26/2016.
 */
public class QueueUsingStacksTest {

    public static void main(String[] args){
        Queue<Integer> q= new QueueUsingStacks<Integer>();
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        System.out.println(q);
       // System.out.println("Peek ele: "+ q.peek());
        System.out.println("DeQueue : "+ q.deQueue());
        System.out.println(q);
        System.out.println("DeQueue : "+ q.deQueue());
        System.out.println(q);

        Assert.assertEquals(1,q.size());
    }

}