package com.twodimensionalarrays;

public class ExitPointOfMatrix {

    public static void main(String[] args) {
        int[][] arr = {{0,0,1,0},
                       {1,0,0,1},
                       {0,0,0,1},
                       {1,0,1,0}};
        int i = 0;
        int j = 0;
        int dir = 0;
        while (true) {
            dir = (dir + arr[i][j]) % 4;

            if (dir == 0) {
                j++;
            } else if (dir == 1) {
                i++;
            } else if (dir == 2) {
                j--;
            } else if (dir == 3) {
                i--;
            }
            else if (i < 0) {
                i++;
                break;
            }
            if (i > arr.length - 1) {
                i--;
                break;
            } else if (j > arr[i].length - 1) {
                j--;
                break;
            } else if (j < 0) {
                j++;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
    }
}
