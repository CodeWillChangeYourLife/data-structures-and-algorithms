package com.trees.generictree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeConstructor {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) {
        int data;
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, -1, 40, 90, -1, -1, -1};
        Node root = null;
        root = constructTree(arr, root);
        displayTree(root);
        int noOfNodes = countNoOfNodesInTree(root);
        System.out.println(noOfNodes);
    }

    static int countNoOfNodesInTree(Node root) {
        //step1 - first oka varible ni create chesi assign 0 as value
        //step2 - input vochina root node ni children read chesi recursive ga countNoOfNodesInTree method ni call cheyali
        //step3 - return chese mundu add +1 to the size

        int size = 0;

        for (Node cn : root.children) {
            int cnSize = countNoOfNodesInTree(cn);
            size = cnSize + size;
        }
        return size + 1;
    }

    static Node findMaxNode(Node root) {

        Node currentMax = root;

        for (Node node : root.children) {
            Node cn = findMaxNode(node);
            if (currentMax.data < cn.data) {
                currentMax = cn;
            }
        }
        return currentMax;
    }

    //data->children data
    static void displayTree(Node root) {
        System.out.print(root.data + " --> ");
        for (Node children : root.children) {
            System.out.print(children.data + " ");
        }
        System.out.println();

        for (Node children : root.children) {
            displayTree(children);
        }
    }

    static Node constructTree(int[] array, Node root) {
        //step1 - Create a Stack with Node
        //step2 - traverse the input array
        //step3 - check each index value , if value = -1 , remove data from the stack, okavela -1 kadhu
        // Node create chesi , ah node ki manam array nunchi read chesina data ni set cheyali
        // check stack is empty or not if it is empty assign the created node into root node , if
        // get the top node from the stack and get chesukunna node children ki mana node ni add cheyali

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                stack.pop();
            } else {
                Node node = new Node();
                node.data = array[i];
                if (stack.isEmpty()) {
                    root = node;
                } else {
                    stack.peek().children.add(node);
                }
                stack.push(node);
            }
        }
        System.out.println(stack.isEmpty());
        return root;
    }
}


