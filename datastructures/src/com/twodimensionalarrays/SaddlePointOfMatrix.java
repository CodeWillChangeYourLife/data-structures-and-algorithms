package com.twodimensionalarrays;

public class SaddlePointOfMatrix {

    public static void main(String[] args) {
        int[][] arr = {{11,10,13,19},
                       {22,21,23,24},
                       {33,32,31,35},
                       {43,42,43,40}};


        for(int i=0;i<arr.length;i++){
            int mci=0;
            for(int j=1;j<arr[i].length;j++){
                if(arr[i][mci]>arr[i][j]){
                    mci=j;
                }
            }
            boolean flag=true;

            for(int k=0;k<arr.length;k++){
                if(arr[i][mci]<arr[k][mci]){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                System.out.println("Saddle Point :"+arr[i][mci]);
            }
        }
    }
}
