package com.twodimensionalarrays;

public class SumOfDiagonals {

    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},
                        {5,6,7,8},
                        {8,7,6,5},
                        {4,3,2,1}};

        int diagonal1=0;

        for(int i=0;i<arr.length;i++){
            diagonal1=diagonal1+arr[i][i];
        }

        System.out.println(diagonal1);

        int diagonal2=0;
        
        for(int i=0, j=arr.length-1;i<arr.length;i++,j--){
            diagonal2=diagonal2+arr[i][j];
        }

        System.out.println(diagonal2);

        System.out.println(diagonal1+diagonal2);
    }
}
