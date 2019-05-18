package com.solutions.algorithms.dynamicprog;

import com.solutions.algorithms.utilities.CustomArrayUtils;
import com.solutions.algorithms.utilities.SubSequences;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Find the longest increasing subsequence from the given array
 */
public class LongestIncreasingSubSeq {

    //Method-1 (Brute force approach)
    //Find all sub sequences and look up for the  desired
    //TC - nc^0 + nc^1...+nc^n = 2^n
    public List<Integer> getLongestIncSubSequence1(Integer[] array){
        SubSequences<Integer> subSequences = new SubSequences<>();
        List<List<Integer>> allSubSeqs = subSequences.getAllSubSequences(array);
        int maxLength =  1;
        List<Integer> resSeq = null;
        System.out.println("Got all subsequences");
        outer: for (List<Integer> res : allSubSeqs ) {
            int tmp = Integer.MIN_VALUE;
            inner: for(Integer y : res){
                if(y > tmp)
                    tmp = y;
                else
                    continue outer;
            }
            if (maxLength < res.size()){
                resSeq = res;
                maxLength = res.size();
            }
        }
        return resSeq;
    }

    //Method-2 Optimize Brute force - TC -> O(2^n)
    //Eliminate the subsequences while finding further
    // 1. If the seq is not increasing
    // 2. at least one seq is found, then stops. Because we are calculating from higher length
    public void getLongestIncSubSequence2(int[] array){
        int len = array.length;
        List<List <Integer>> allSequences = new ArrayList<>();
        outer: for(int i=len; i>0; i--){
            inner: for(int j=0; j<=(len-i); j++){
                List<Integer> sequence = new LinkedList<>();
                sequence.add(array[j]);
                boolean res = auxGetAllSequences(array, j+1, i-1,sequence, allSequences);
                if(res)
                    break outer;
            }
        }

        for(int i=0; i<allSequences.size(); i++){
            System.out.println(allSequences.get(i));
        }
    }

    private boolean auxGetAllSequences(int[] array, int start, int rem, List<Integer> sequence, List<List<Integer>> allSequences){
        if(rem == 0){
            allSequences.add(sequence);
            return true;
        }

        int lastElement = sequence.get(sequence.size()-1);
        for(int i= start; i<array.length; i++){
            if(array[i] <= lastElement)
                continue;
            List<Integer> newSequence = new LinkedList<>(sequence);
            newSequence.add(array[i]);
            boolean res = auxGetAllSequences(array, i+1, rem-1, newSequence, allSequences);
            if(res) return true;
        }

        return  false;
    }

    //Method-3
    //Using
    // LIS[0,n-1] = { 1 + max( LIS[i,j] where 0<i<j && a[i] < a[j] }
    //DP: TC-> O(n^2) and SC -> O(n)
    public void getLongestIncSubSequence3(int[] array){
        int length = array.length;
        int[] mem = new int[length];
        for(int i=0; i<length; i++){
           mem[i] = 1;
        }

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>());
        lists.get(0).add(array[0]);

        int maxLength = 1;
        List<Integer> sequence = null;
        for(int i=1; i<length; i++){
            lists.add(new ArrayList<>());
            for(int j=0; j<i; j++){
                if(array[j] < array[i] && (1+mem[j]) > mem[i]){
                    mem[i] = 1+mem[j];
                    lists.get(i).add(array[j]);
                    if(maxLength < mem[i]){
                        maxLength = mem[i];
                        sequence = lists.get(i);
                    }

                }
            }
            lists.get(i).add(array[i]);
        }
        System.out.println("Max length sequence: " + maxLength);
        System.out.println("Max Length sequence "+ sequence);
    }


    public static void main(String[] args){
        LongestIncreasingSubSeq longestIncreasingSubSeq = new LongestIncreasingSubSeq();
        int[] data = new int[]{0,0,0,0,0,0,1,1,1,1,2,3,0,0,0,1,1,0,1,1,0,1,0,3};

        longestIncreasingSubSeq.getLongestIncSubSequence2(data);
        longestIncreasingSubSeq.getLongestIncSubSequence3(data);

        Integer[] res = CustomArrayUtils.intToIntegerArray(data);
        System.out.println(longestIncreasingSubSeq.getLongestIncSubSequence1(res));
    }


}
