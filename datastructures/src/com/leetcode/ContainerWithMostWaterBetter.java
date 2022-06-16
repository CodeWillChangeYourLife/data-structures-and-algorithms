package com.leetcode;

public class ContainerWithMostWaterBetter {
    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int area = Math.min(height[left], height[right]) * (right - left);
            if (maxArea < area) {
                maxArea = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(maxArea);
    }
}
