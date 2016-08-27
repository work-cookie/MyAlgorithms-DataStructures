package com.solutions.algorithms.dynamicprog;

/**
 * Created by chch0316 on 8/23/2016.
 */
public class NthFibanocci {

    //TC-> O(2^n) and SC-> O(n)
    public static long fib1(int n){
        if(n==1) return 1;
        if(n==0) return 0;
        return fib1(n-1)+fib1(n-2);
    }

    //TC-> O(n) and SC-> O(n) (Recursion+memory = memoization)
    public static long fib2(int n){
        long[] mem = new long[n+1];
        return fib2(n,mem);
    }
    private static long fib2(int n,long[] mem){
        if(n==1) return 1;
        if(n==0) return 0;
        if(mem[n]==0)
            mem[n] = fib2(n-1,mem)+ fib2(n-2,mem);
        return mem[n];
    }

    //TC-> O(n) and SC-> O(n) (Dynamic programming)
    public static long fib3(int n){
        long[] mem = new long[n+1];
        mem[0]=0;
        mem[1]=1;
        int i;
        for (i = 2; i <=n ; i++) {
            mem[i]=mem[i-1]+mem[i-2];
        }
        return mem[n];
    }
    //TC-> O(n) and SC-> O(1)
    public static long fib4(int n){
        if(n==1) return 1;
        if(n==0) return 0;
        int x=0,y=1,z;
        for (int i = 2; i <=n ; i++) {
            z = x+y;
            x=y;
            y=z;
        }
        return y;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(fib1(n));
        System.out.println(fib2(n));
        System.out.println(fib3(n));
        System.out.println(fib4(n));

        boolean yes = "ghhh".contains(" ");
        System.out.println(yes);

    }
}
