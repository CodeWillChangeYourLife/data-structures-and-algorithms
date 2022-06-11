package com.leetcode;

public class MaidenOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] a = {3, 5, 8, 10, 15};
        int[] b = {2, 4, 12};
        // merged array looks like this
        //{2,3,4,5,7,10,12,15}
        //Brute Force Approach not recommended
        int[] c = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = a[j++];
        }

        //display merged sorted array is

        for (int x = 0; x < c.length; x++) {
            System.out.print(c[x] + " ");
        }
        System.out.println();

        if (c.length % 2 == 0) {
            double maiden = (c[c.length / 2] + c[(c.length / 2) - 1]) % 2;
            System.out.println(maiden);
        } else {
            double maiden = (c[(c.length / 2) + 1]) % 2;
            System.out.println("else part maiden " + maiden);
        }
    }
}
