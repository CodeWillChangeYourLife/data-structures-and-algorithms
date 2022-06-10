package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumBetterTimeComplexity {

    public static void main(String[] args) {
        int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
        int target = 9;
        //This is BruteForce Approach
        int[] twoSumIndexes = findTwoSum(arr, target);

        System.out.println("Two Sum Indexes");

        for (int a : twoSumIndexes) {
            System.out.print(a + " ");
        }
    }

    private static int[] findTwoSum(int[] arr, int target) {
        Map<Integer, Integer> backUpData = new HashMap<>();

        int[] result = new int[2];
        int y = 0;
            //{3, 5, -4, 8, 11, 1, -1, 6};
        for (int i = 0; i < arr.length; i++) {
            y = target - arr[i];
            if (backUpData.containsKey(y)) {
                result[0] = backUpData.get(y);
                result[1] = i;
                return result;
            } else {
                backUpData.put(arr[i], i);
            }
        }
        return null;
    }
}
