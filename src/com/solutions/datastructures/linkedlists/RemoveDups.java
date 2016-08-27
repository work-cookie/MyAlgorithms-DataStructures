package com.solutions.datastructures.linkedlists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by chch0316 on 8/23/2016.
 */
public class RemoveDups {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    //TC-> O(n) and SC-> O(n)
    static void removeDup1(Node head){
        if(head==null)
            return;
        HashSet<Integer> hSet = new HashSet<Integer>();
        hSet.add(head.data);
        Node current = head;
        while (current.next!=null) {
            if (hSet.contains(current.next.data))
                current.next = current.next.next;
            else {
                hSet.add(current.next.data);
                current = current.next;
            }
        }
    }

    //TC-> O(n^2) and SC-> O(1)
    static void removeDup2(Node head){
        if(head==null) return;
        Node current = head,fast=null;
        while (current!=null){
            fast = current;
            while (fast.next!=null){
                if(current.data==fast.next.data)
                    fast.next= fast.next.next;
                else
                    fast=fast.next;
            }
            current=current.next;
        }
    }

    //TC-> O(n) and SC-> O(1)
    static void removeDupInSortedLL(Node head){
        if(head==null) return;

        Node current = head,runner = null;
        while (current!=null){
            runner = current;
            while (runner.next!=null && runner.next.data== current.data){
                runner.next = runner.next.next;
            }
            current= current.next;
        }
    }

    static void display(Node head){
        Node current = head;
        System.out.println();
        while (current!=null){
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.print("Null");
    }

    public static void main(String[] args) {
       Node head = new Node(10);
        head.next = new Node(34);
        head.next.next = new Node(67);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(34);
        head.next.next.next.next.next = new Node(34);
        head.next.next.next.next.next.next = new Node(34);

        display(head);
        removeDup2(head);
        display(head);

        Node head1 = new Node(10);
        head1.next = new Node(10);
        head1.next.next = new Node(20);
        head1.next.next.next = new Node(20);
        head1.next.next.next.next = new Node(20);
        head1.next.next.next.next.next = new Node(20);
        head1.next.next.next.next.next.next = new Node(30);

        display(head1);
        removeDupInSortedLL(head1);
        display(head1);

        String s="03/18/2016";

        try {
            Date d= new SimpleDateFormat("MM/dd/yyyy").parse(s);
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
