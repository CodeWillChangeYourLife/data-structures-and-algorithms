package com.customcollection;

import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {

        int[] arr = {2, 4, 5, 3, 7, 9, 4, 2, 3, 5};
        int[] stockSpan = findStockSpan(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(stockSpan[i]+" ");
        }
    }

    static int[] findStockSpan(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                result[i] = i + 1;
            } else {
                result[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}
