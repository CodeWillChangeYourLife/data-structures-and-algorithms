package com.ds.generictrees;

import java.util.ArrayList;
import java.util.Stack;

public class DisplayGenericTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
    }

    public void displayTree(Node root) {
        if (root == null) {
            System.out.println("Invalid data");
        }
        System.out.print(root.data + "--> ");
        for (Node child : root.children) {
            System.out.print(child.data + " ");
        }
        System.out.println();

        for (Node child : root.children) {
            displayTree(child);
        }
    }

    public void constructTree(int[] arr) {
        if (arr == null || arr.length < 1) {
            System.out.println("Invalid data");
            return;
        }
        Node root = null;
        Stack<Node> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node node = new Node();
                node.data = arr[i];
                if (st.size() == 0) {
                    root = new Node();
                    root.data = arr[i];
                    st.push(root);
                } else {
                    st.peek().children.add(node);
                    st.push(node);
                }
            }
        }

        displayTree(root);
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, -1, 40, -1, -1};

        DisplayGenericTree dg = new DisplayGenericTree();
        dg.constructTree(data);
    }

}
