package com.twodimensionalarrays;

public class MatrixShellRotation {
    public static void main(String[] args) {

        String[][] str = {{"a", "o", "n", "m"},
                          {"e", "x", "n", "l"},
                          {"f", "y", "m", "k"},
                          {"g", "h", "i", "j"}};
        int s = 1;
        int r = 4;
        rotateShell(str, s, r);
        System.out.println();

        for(int i=0;i<str.length;i++){
            for(int j=0;j<str[i].length;j++){
                System.out.print(str[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotateShell(String[][] str, int s, int r) {

        // step1 createOneDArrayAndpushShell1Elements into it
        String[] oneDArray = constructOneDArrayFromShell(str, s);
        printStringArray(oneDArray);
        //step rotate array
        rotateOneDArray(oneDArray, s, r);
        printStringArray(oneDArray);
        //step construct back 1d array to shell
        constructOneDArrayToShell(str,oneDArray,s);
    }

    private static void constructOneDArrayToShell(String[][] str, String[] oneDArray, int s) {

        int minC=s-1;
        int minR=s-1;
        int maxC=str[0].length-s;
        int maxR=str.length-s;
        int index = 0;

        for(int i=minR, j=minC;i<=maxR;i++){
            str[i][j]=oneDArray[index];
            index++;
        }
        minC++;

        for(int i=minC, j=maxR;i<=maxC;i++){
            str[j][i]=oneDArray[index];
            index++;
        }
        maxR--;

        for(int i=maxR,j=maxC;i>=minR;i--){
            str[i][j]=oneDArray[index];
            index++;
        }
        maxC--;

        for(int i=maxC, j=minR;i>=minC;i--){
            str[j][i]=oneDArray[index];
            index++;
        }
        minR--;
    }

    private static void printStringArray(String[] oneDArray) {
        for (int i = 0; i < oneDArray.length; i++) {
            System.out.print(oneDArray[i] + " ");
        }
        System.out.println();
    }

    private static void rotateOneDArray(String[] oneDArray, int s, int r) {
        r = r % oneDArray.length;

        if (r < 0) {
            r = r + oneDArray.length;
        }
        reverse(oneDArray, 0, oneDArray.length - 1 - r);
        reverse(oneDArray, oneDArray.length - r, oneDArray.length - 1);
        reverse(oneDArray, 0, oneDArray.length - 1);
    }

    private static void reverse(String[] oneDArray, int start, int end) {

        while (start < end) {
            String temp = oneDArray[start];
            oneDArray[start] = oneDArray[end];
            oneDArray[end] = temp;
            start++;
            end--;
        }
    }

    private static String[] constructOneDArrayFromShell(String[][] str, int s) {
        int minC = s - 1;
        int minR = s - 1;
        int maxR = str.length - s;
        int maxC = str[0].length - s;

        int arraySize = 2 * (maxR - minR + maxC - minC);

        String[] oneDArray = new String[arraySize];
        int index = 0;

        //lw
        for (int i = minR, j = minC; i <= maxR; i++) {
            oneDArray[index] = str[i][j];
            index++;
        }
        minC++;

        //bw

        for (int i = minC, j = maxR; i <= maxC; i++) {
            oneDArray[index] = str[j][i];
            index++;
        }
        maxR--;

        //rw

        for (int i = maxR, j = maxC; i >= minR; i--) {
            oneDArray[index] = str[i][j];
            index++;
        }
        maxC--;

        //tw
        for (int i = maxC, j = minR; i >= minC; i--) {
            oneDArray[index] = str[j][i];
            index++;
        }
        minR++;
        return oneDArray;
    }
}
