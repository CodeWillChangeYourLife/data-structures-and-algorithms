package com.twodimensionalarrays;

public class ConvertMatrixShellToOneDArray {

    public static void main(String[] args) {
        String[][] arr = {{"a", "b", "c", "d"},
                {"e", "f", "g", "h"},
                {"i", "j", "k", "l"},
                {"m", "n", "o", "p"}};

        int s = 1;
        String[] cArray = constructOneDArray(arr, s);

        for (int i = 0; i < cArray.length; i++) {
            System.out.print(cArray[i] + " ");
        }

    }

    private static String[] constructOneDArray(String[][] arr, int s) {
        int minC = s - 1;
        int minR = s - 1;
        int maxR = arr.length - s;
        int maxC = arr[0].length - s;

        int size = 2 * (maxR - minR + maxC - minC);

        String[] str = new String[size];
        int index = 0;

        //lw
        for (int i = minR, j = minC; i <= maxR; i++) {
            str[index] = arr[i][j];
            index++;
        }
        minC++;

        //bw
        for (int i = minC, j = maxR; i <= maxC; i++) {
            str[index] = arr[j][i];
            index++;
        }
        maxR--;
        //rw
        for (int i = maxR, j = maxC; i >= minR; i--) {
            str[index] = arr[i][j];
            index++;
        }
        maxC--;

        //tw
        for (int i = maxC, j = minR; i >= minC; i--) {
            str[index] = arr[j][i];

            index++;
        }
        minR++;

        return str;
    }
}
