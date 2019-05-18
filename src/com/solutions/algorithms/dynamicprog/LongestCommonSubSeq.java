package com.solutions.algorithms.dynamicprog;

public class LongestCommonSubSeq {

    //Method-1
    //TC - O(2^(m+n))
    public int getCommonSequence(String x, String y){
        int m = x.length();
        int n = y.length();
        return LCS(x,y,m,n);
    }

    private int LCS(String x, String y, int m, int n){
        if(m==0 || n==0)
            return 0;
        if(x.charAt(m-1) == y.charAt(n-1))
            return 1+LCS(x,y,m-1,n-1);

        return Math.max(LCS(x,y,m,n-1), LCS(x,y,m-1,n));
    }


     private int[][] fillLookUpTable(String x, String y,int m,int n){
        int[][] mem = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    mem[i][j] = 1+mem[i-1][j-1];
                } else {
                    mem[i][j] = Math.max(mem[i][j-1], mem[i-1][j]);
                }
            }
        }

        return mem;
    }

    //Method-2
    //TC - O(m*n) SC - O(m*n)
    public int getCommonSequence2(String x, String y){
        int m = x.length();
        int n = y.length();
        int[][] mem = fillLookUpTable(x,y,m,n);
        return mem[m][n];
    }


    //Method-3 Get the common sequence
    //TC - O(m*n) SC - O(m*n)
    public String getCommonSequence3(String x, String y){
        int m = x.length();
        int n = y.length();
        int[][] mem = fillLookUpTable(x,y,m,n);

        String tmp = "";
        while(m!=0 && n!=0){
            if(x.charAt(m-1) == y.charAt(n-1)){
                tmp = x.charAt(m-1) + tmp;
                m--;
                n--;
            } else{
                if(mem[m][n-1] > mem[m-1][n]){
                    n--;
                } else
                    m--;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        LongestCommonSubSeq lcs = new LongestCommonSubSeq();
        String x = "AGGTAB";
        String y = "GXTXAYB";
        System.out.println(lcs.getCommonSequence(x,y));
        System.out.println(lcs.getCommonSequence2(x,y));
        System.out.println(lcs.getCommonSequence3(x,y));
    }


}
