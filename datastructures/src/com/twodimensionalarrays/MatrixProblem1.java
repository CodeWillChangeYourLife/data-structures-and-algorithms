package com.twodimensionalarrays;

public class MatrixProblem1 {

    public static void main(String[] args) {

        String[][] arr = {{"A","A","A"},
                          {"B","B","B"},
                          {"C","C","C"}};

        System.out.println("BEFORE ===========");
        displayMatrix(arr);

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr[i].length;j++){
                String temp = arr[i][j];
                arr[i][j]= arr[j][i];
                arr[j][i]=temp;
            }
        }
        System.out.println("AFTER ================");
        displayMatrix(arr);
    }

    static void displayMatrix(String[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
