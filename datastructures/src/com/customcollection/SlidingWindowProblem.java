package com.customcollection;

import java.util.Stack;

public class SlidingWindowProblem {

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 3, 4, 5, 76, 8, 9, 0, 66, 8, 9, 3, 4, 7};
        int[] nextGreatestElement = findNge(arr);
        System.out.println("Next GE");
        for (int i = 0; i < nextGreatestElement.length; i++) {
            System.out.print(nextGreatestElement[i] + " ");
        }
        System.out.println();
        int j = 0;
        int k = 4;
        for (int i = 0; i < arr.length - k; i++) {
            if (j < i) {
                j = i;
            }
            while (nextGreatestElement[j] < i + k) {
                j = nextGreatestElement[j];
            }
            System.out.print(arr[j] + " ");
        }
    }

    static int[] findNge(int[] arr) {
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                nge[i] = arr.length;
            } else {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        return nge;
    }
}
