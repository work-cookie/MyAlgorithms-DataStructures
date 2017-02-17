package com.solutions.algorithms.bits;

/**
 * Created by ADMIN-COOLUCAN on 2/16/2017.
 */
public class Shifting {
    public static void main(String[] args) {
        int x = -16;
        System.out.println(x<<1);

        //Right shift with MSB as sign bit
        System.out.println(x>>1);

        //Right shift with MSB as 000
        System.out.println(x>>>1);
    }
}
