package test.com.solutions.datastructures.stacks;

import com.solutions.datastructures.stacks.LinkedStack;
import com.solutions.datastructures.stacks.Stack;

import static org.junit.Assert.*;

/**
 * Created by chch0316 on 7/26/2016.
 */
public class LinkedStackTest {

    public static void main(String[] args){
        Stack<Integer> ls = new LinkedStack();
        ls.push(100);
        ls.push(45);
        ls.push(67);
        ls.push(200);
        ls.push(465);
        ls.push(678);
        System.out.println(ls);
        ls.pop();
        System.out.println(ls);
        System.out.println("Peek ele : "+ls.peek());
        System.out.println("Size : "+ls.size());
    }
}