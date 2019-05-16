package com.solutions.algorithms.dynamicprog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Find the longest increasing subsequence from the given array
 */
public class LongestIncreasingSubSeq {

    //Method-1
    //Bruteforce - TC -> O(n^2)
    public void getAllSequences(int[] array){
        int len = array.length;
        List<List <Integer>> allSequences = new ArrayList<>();
        outer: for(int i=len; i>0; i--){
            inner: for(int j=0; j<len; j++){
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
        if(rem == 0 || start >= array.length){
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

    public static void main(String[] args){
        LongestIncreasingSubSeq longestIncreasingSubSeq = new LongestIncreasingSubSeq();
        longestIncreasingSubSeq.getAllSequences(new int[]{0,0,0,0,0,0,1,1,1,1,2,3,0,0,0,1,1,0,1,1,0,1,0,3});
    }

}
