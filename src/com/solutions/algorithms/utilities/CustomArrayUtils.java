package com.solutions.algorithms.utilities;

public class CustomArrayUtils {

    public static Integer[] intToIntegerArray(int[] data){
        Integer[] res = new Integer[data.length];
        for(int i=0; i<data.length; i++)
            res[i] = Integer.valueOf(data[i]);
        return res;
    }

}
