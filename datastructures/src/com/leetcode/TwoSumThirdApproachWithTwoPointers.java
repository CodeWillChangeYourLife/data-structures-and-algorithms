package com.leetcode;

public class TwoSumThirdApproachWithTwoPointers {

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 9, 3, 13, 4, 7, 6, -4};
        int target = 10;

        int[] data = fidTwoSumWithTwoPointers(arr, target);

        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static int[] fidTwoSumWithTwoPointers(int[] arr, int target) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        int ls = 0;
        int rs = arr.length - 1;
        int[] result = new int[2];
        while (ls < rs) {
            if (arr[ls] + arr[rs] > target) {
                rs--;
            } else if (arr[ls] + arr[rs] < target) {
                ls++;
            } else if (arr[ls] + arr[rs] == target) {
                result[0] = ls;
                result[1] = rs;
                return result;
            }
        }
        return null;
    }
}
