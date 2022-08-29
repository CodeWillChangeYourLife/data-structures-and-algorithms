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
        int[] arr = {10, 20, 50, -1, 90, -1, -1, 30, 70, -1, 80, -1, -1, 40, 60, -1, -1, -1};
        Node root = null;
        //Q1 Construct Generic Tree from the input array data
        root = constructTree(arr, root);

        //Q2 Display a Constructed Generic Tree
        displayTree(root);
        //Q3 Find node count in a Generic Tree
        int noOfNodes = countNoOfNodesInTree(root);
        System.out.println("Number Of Nodes In Tree : " + noOfNodes);

        Node maxNode = findMaxNode(root);
        System.out.println("Max Node In A Tree : " + maxNode.data);
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
        //step1- vochina root node ni max noda ga assume chesukovali
        //step2- for each loop use chesi anni nodes traversa cheyali recursive ga
        //step3 - for each loop lopala logic -> evry node data ni manam initial ga assume chesukunna
        //maxNode data tho compare cheyali oka vela , manam assume chesukunna maxnode data kantey
        // for each loop lo vochina node data ekkuva vuntey apudu foreach lo vunna node ni maxNoda
        // ki assign cheyali,same stepa anni nodes ki follow avali
        //Step4: Final ga maxNode ni return cheyali

        //Code
        //step1
        Node maxNode = root;

        for (Node child : root.children) {
            Node currentMax = findMaxNode(child);
            if (currentMax.data > maxNode.data) {
                maxNode = currentMax;
            }
        }
        return maxNode;
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
