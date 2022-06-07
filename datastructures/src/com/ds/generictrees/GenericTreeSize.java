package com.ds.generictrees;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeSize {

    static class Node {
        int data;
        ArrayList<Node> child = new ArrayList<>();
    }

    public static void main(String[] args) {

        Node root = null;

        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, -1, 40, -1, -1};

        Stack<Node> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == -1) {
                st.pop();
            } else {

                if (st.size() == 0) {
                    root = new Node();
                    root.data = arr[i];
                    st.push(root);
                } else {
                    Node node = new Node();
                    node.data = arr[i];
                    st.peek().child.add(node);
                    st.push(node);
                }
            }
        }
        System.out.println(sizeOfTree(root));
    }

    private static int sizeOfTree(Node root) {

        int s = 0;

        for (Node child : root.child) {
            int sz = sizeOfTree(child);
            s = s + sz;
        }
        s = s + 1;
        return s;
    }
}
