package test.com.solutions.datastructures.stacks;

import com.solutions.datastructures.stacks.LinkedStack;
import com.solutions.datastructures.stacks.Stack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

        String s= "\"assss1\"";
        System.out.println(s.substring(1,s.length()-1));
        System.out.println(s.charAt(s.length()-1));
        System.out.println(s.contains("asd"));

        Date d = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(d);
        calendar.add(Calendar.MONTH , 4);

        System.out.println(calendar.getTime());

        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        final SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );

        System.out.println(d.toString());
    }
}