package com.solutions.algorithms.utilities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSequences<T> {

    private void getAllSubSequences(T[] array, int start, int rem, List<T> sequence, List<List<T>> allSequences){
        if(rem == 0 ){
            allSequences.add(sequence);
            return;
        }

        for(int i= start; i<array.length; i++){
            List<T> newSequence = new LinkedList<>(sequence);
            newSequence.add(array[i]);
            getAllSubSequences(array, i+1, rem-1, newSequence, allSequences);
        }

    }
    public List<List<T>> getAllSubSequences(T[] array){
        int len = array.length;
        List<List <T>> allSequences = new ArrayList<>();
        outer: for(int i=len; i>0; i--){
            inner: for(int j=0; j<=(len-i); j++){
                List<T> sequence = new LinkedList<>();
                sequence.add(array[j]);
                getAllSubSequences(array, j+1, i-1,sequence, allSequences);
            }
        }

        return allSequences;
    }

    public static void main(String[] args) {
        SubSequences<Integer> subSequences = new SubSequences<>();
        Integer[] data = new Integer[]{3,5,7,2};
        List<List<Integer>> result = subSequences.getAllSubSequences(data);
        for(List<Integer> r : result)
            System.out.println(r);
    }

}
