package com.trees.binarytree;

import java.util.Stack;

public class BinaryTree {
    static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Integer[] data = {10, 20, 40, null, null, 50, 60, null, null, null, 30, 70, null, 90, null, null, 80, null, null};
        Node root = null;
        //Q1- జావా లో బైనరీ ట్రీ  ఎలా బిల్డ్ చేయాలి ALGORITHM CODE
        // Java lo Binary tree construction ALGORITHM CODE
        root = constructBinaryTree(data);
        System.out.println(root.data);

    }

    static Node constructBinaryTree(Integer[] inputArray) {
        Node rootNode = null;
        Pair pair = null;
        Node node = null;
        Stack<Pair> pairs = new Stack<>();
        rootNode = new Node(inputArray[0]);
        pair = new Pair(rootNode, 1);
        pairs.push(pair);
        int index = 0;

        while (pairs.size() > 0) {
            Pair topPair = pairs.peek();
            index++;
            if (topPair.state == 1) {
                if (inputArray[index] != null) {
                    node = new Node(inputArray[index]);
                    topPair.node.leftNode = node;
                    pair = new Pair(node, 1);
                    pairs.push(pair);
                } else {
                    topPair.node.leftNode = null;
                }
                topPair.state++;
            } else if (topPair.state == 2) {
                if (inputArray[index] != null) {
                    node = new Node(inputArray[index]);
                    topPair.node.rightNode = node;
                    pair = new Pair(node, 1);
                    pairs.push(pair);
                } else {
                    topPair.node.rightNode = null;
                }
                topPair.state++;
            } else {
                pairs.pop();
            }
        }
        return rootNode;
    }
}