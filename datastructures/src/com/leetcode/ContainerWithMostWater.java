package com.leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int maxAreaOfWater = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int length = Math.min(height[i], height[j]);
                int width = (j - i);
                int newArea = (length * width);
                if (maxAreaOfWater < newArea) {
                    maxAreaOfWater = newArea;
                }
            }
        }
        System.out.println(maxAreaOfWater);
    }
}
