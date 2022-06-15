package com.leetcode;

public class MaidenOfTwoSortedArrayLogTime {

    public static void main(String[] args) {

        int[] a = {1,2,3};
        int[] b = {4,5,6};

        System.out.println(findMaiden(a, b));
    }

    private static double findMaiden(int[] a, int[] b) {

        if (a.length > b.length) {
            return findMaiden(b, a);
        }

        int lengthA = a.length;
        int lengthB = b.length;

        int low = 0;
        int high = a.length;
        while (low <= high) {

            int partA = low + high / 2;
            int partB = (lengthB + lengthA + 1) / 2 - partA;

            int maxLA = partA == 0 ? Integer.MIN_VALUE : a[partA - 1];
            int minRA = partA == lengthA ? Integer.MAX_VALUE : a[partA];

            int maxLB = partB == 0 ? Integer.MIN_VALUE : b[partB - 1];
            int minRB = partB == lengthB ? Integer.MAX_VALUE : b[partB];

            if (maxLA <= minRA && maxLB <= minRA) {
                if ((lengthA + lengthB) % 2 == 0) {
                    return ((double) Math.max(maxLA, maxLB) + Math.min(minRB, minRA)) / 2;
                } else {
                    return (double) Math.max(maxLA, maxLB);
                }
            } else if (maxLA > minRB) {
                high = partA - 1;
            } else {
                low = partA + 1;
            }

        }
        return 0.0;
    }
}
