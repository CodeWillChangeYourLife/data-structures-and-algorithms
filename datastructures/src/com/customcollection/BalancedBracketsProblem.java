package com.customcollection;

import java.util.Stack;

public class BalancedBracketsProblem {

    public static void main(String[] args) {
        String str = "[{(a+b)+(c+d)}]";
        boolean result = checkBrackets(str);
        System.out.println(result);
    }

    static boolean checkBrackets(String str) {
        if (str.length() == 1 || str.isEmpty()) {
            return false;
        }
        char[] ch = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '[' || ch[i] == '(' || ch[i] == '{') {
                stack.push(ch[i]);
            } else if (ch[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch[i] == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
