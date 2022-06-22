package com.leetcode;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 4, 5};
        int target = 3;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                int temp = nums[max];
                nums[max] = nums[i];
                nums[i] = temp;
                max++;
            }
        }

        for(int x=0;x<max;x++){
            System.out.print(nums[x]+" ");
        }
    }
}
