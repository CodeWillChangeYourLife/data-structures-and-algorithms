package com.twodimensionalarrays;

public class SearchAnElementInAMatrix {

    public static void main(String[] args) {

        int[][] arr = {{10, 11, 13, 14},
                       {21, 24, 26, 28},
                       {30, 31, 32, 35},
                       {40, 44, 56, 78}};

        int target = 44;

        for(int i=0;i<arr.length;i++){

            for(int j=arr[i].length-1;j>=0;j--){
                if(arr[i][j]==target){
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }else if(arr[i][j]<target){
                    break;
                }
            }
        }

    }
}
