package com.twodimensionalarrays;

public class SumOfUppterTriangleDiagnol {

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4},{5,6}};


        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] mt = new int[arr[1].length][arr.length];

        System.out.println(arr[1].length);
        System.out.println(arr.length);

        for(int i=0;i<arr[1].length;i++){
            for(int j=0;j<arr.length;j++){
                mt[i][j]=arr[j][i];
            }
        }

        for(int i=0;i<mt.length;i++){
            for(int j=0;j<mt[i].length;j++){
                System.out.print(mt[i][j]+" ");
            }
            System.out.println();
        }
    }
}
