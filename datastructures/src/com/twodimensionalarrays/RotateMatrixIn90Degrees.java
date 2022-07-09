package com.twodimensionalarrays;

public class RotateMatrixIn90Degrees {

    public static void main(String[] args) {
        String[][] arr = {{"a", "b", "c", "d"},
                          {"e", "f", "g", "h"},
                          {"i", "j", "k", "l"},
                          {"m", "n", "o", "p"}};

        displayArray(arr);
        //step1 Transpose the Matrix

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr[i].length;j++){
                String temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        displayArray(arr);
        //step2 reverse each row

        for(int i=0;i<arr.length;i++){

            int li=0;
            int ri=arr.length-1;

            while(li<ri){
                String temp = arr[i][li];
                arr[i][li]=arr[i][ri];
                arr[i][ri]=temp;
                li++;
                ri--;
            }
        }
        displayArray(arr);
    }

    private static void displayArray(String[][] arr) {
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
