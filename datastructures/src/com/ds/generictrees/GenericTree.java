package com.ds.generictrees;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, -1, 40, -1, -1};
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == -1) {
                st.pop();
            } else {
                if (st.size() > 0) {
                    Node node = new Node();
                    node.data = arr[i];
                    st.peek().children.add(node);
                    st.push(node);
                } else {
                    root = new Node();
                    root.data = arr[i];
                    st.push(root);
                }
            }
        }
        display(root);
    }

    public static void display(Node root) {
        System.out.print(root.data + "-->");
        for (Node child : root.children) {
            System.out.print(child.data + " ");
        }
        System.out.println();
        for (Node c : root.children) {
            display(c);
        }
    }
}
