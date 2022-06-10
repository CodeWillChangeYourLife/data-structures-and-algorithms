package com.leetcode;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 2, 5, 4, 2};
        int target = 9;
        //This is BruteForce Approach
        int[] twoSumIndexes = findTwoSum(arr, target);

        System.out.println("Two Sum Indexes");

        for (int a : twoSumIndexes) {
            System.out.print(a + " ");
        }
    }

    private static int[] findTwoSum(int[] arr, int target) {
        int[] result = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
