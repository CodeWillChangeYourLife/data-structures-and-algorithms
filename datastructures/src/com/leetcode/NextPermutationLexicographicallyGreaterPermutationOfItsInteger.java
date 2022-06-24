package com.leetcode;

public class NextPermutationLexicographicallyGreaterPermutationOfItsInteger {

    public static void main(String[] args) {

       // int[] nums = {4, 1, 7, 5, 3, 2, 0};
        int[] nums = {1,1,5};

        int i = nums.length - 2;
        int j = 0;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);


        for (int x : nums) {
            System.out.print(x+ " ");
        }
    }

    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i, int j) {

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
