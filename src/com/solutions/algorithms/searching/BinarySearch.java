package com.solutions.algorithms.searching;

/**
 * Created by ADMIN-COOLUCAN on 2/16/2017.
 */
public class BinarySearch {

    public static int doBinarySearch(int[] input,int element){
        if(input== null)
            return -1;
        int end = input.length -1;
        return auxBinarySearch(input,0,end,element);
    }

    private static int auxBinarySearch(int[] input,int start,int end,int element){
        if(start > end) return -1;
        int mid = start +(end-start)/2;
        if(input[mid]==element)
            return mid;
        if (input[mid] > element)
            return auxBinarySearch(input,start,mid-1,element);
        else
            return auxBinarySearch(input,mid+1,end,element);
    }


    public static int binarySearchIter(int[] intput,int element){
        int start = 0;
        int end = intput.length-1;
        while (start <= end){
            int mid = start+(end-start)/2;
            if(intput[mid]==element)
                return mid;
            if(intput[mid] < element)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] input = {3,6,45,100,133,456,999};
        int res = doBinarySearch(input,9999);
        System.out.println("Is given element present in the input array? :"+res);
        System.out.println("Is given element present in the input array? :"+binarySearchIter(input,9999));
    }


}
