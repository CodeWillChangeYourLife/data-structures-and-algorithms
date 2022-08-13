package com.customcollection;

import java.util.Stack;

public class NextGreatestElement {

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 5, 6, 4, 65, 7, 8};
        System.out.println("Original Array Data");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int[] result = findNextGreatestElement(arr);
        System.out.println();
        System.out.println("Next Greatest Elements of Original Array");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    static int[] findNextGreatestElement(int[] arr) {
        if (arr.length == 1) {
            return null;
        }
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (stack.size() > 0 && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
