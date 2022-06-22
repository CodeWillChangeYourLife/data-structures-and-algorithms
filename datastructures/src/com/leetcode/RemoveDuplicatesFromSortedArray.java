package com.leetcode;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }

        for (int x = 0; x < i + 1; x++) {
            System.out.print(nums[x] + " ");
        }
    }
}
