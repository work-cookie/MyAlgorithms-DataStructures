package com.solutions.algorithms.dynamicprog;

/**
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.

 * Created by chch0316 on 8/23/2016.
 */

public class Staircase {

    public static long findWays1(int n){
        if(n==2) return 2;
        if(n==1) return 1;
        if(n==0) return 1;
        return findWays1(n-1)+findWays1(n-2)+findWays1(n-3);
    }

    public static long findWays2(int n){
        long [] mem= new long[n+1];
        return findWays2(n,mem);
    }
    private static long findWays2(int n,long[] mem){
        if(n==2||n==1) return n;
        if(n==0) return 1;
        if(mem[n]==0)
            mem[n]= findWays2(n-1,mem)+findWays2(n-2,mem)+findWays2(n-3,mem);
        return mem[n];
    }

    public static long findWays3(int n){
        long [] mem= new long[n+1];
        mem[0]=1;
        mem[1]=1;
        mem[2] =2;
        int i;
        for (i = 3; i <=n ; i++) {
            mem[i]= mem[i-1]+mem[i-2]+mem[i-3];
        }
        return mem[n];
    }

}
