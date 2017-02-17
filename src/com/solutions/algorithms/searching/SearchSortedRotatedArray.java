package com.solutions.algorithms.searching;

/**
 * Created by ADMIN-COOLUCAN on 2/16/2017.
 */
public class SearchSortedRotatedArray {

    public static int findRotatedIndex(int[] input){
        int end = input.length-1;
        int index = auxFindRotatedIndex(input,0,end);
        if(index+1 <= end && input[index] >= input[index+1]){
            return index+1;
        }
        return index;
    }
    private static int auxFindRotatedIndex(int[] input,int start,int end){
        if(start == end)
            return end;
        int mid = start+(end-start)/2;
        if(input[0] < input [mid]){
            return auxFindRotatedIndex(input,mid+1,end);
        }else{
            return auxFindRotatedIndex(input,start,mid-1);
        }
    }

    public static void main(String[] args) {
        int[] input = {23,45,67,89,89,100,3,5,7};
        System.out.println(findRotatedIndex(input));
    }

}
