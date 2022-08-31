package com.trees.generictree;

import com.customcollection.MyQueue;

import java.util.*;

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

        //Q4 Find the max node in a tree
        Node maxNode = findMaxNode(root);
        System.out.println("Max Node In A Tree : " + maxNode.data);

        //Q5 Find the height of a given tree
        int treeHeight = findHeightOfTree(root);
        System.out.println("Tree Height : " + treeHeight);

        //Q6 Traverse the tree with pre node, post node , pre edge nodes and post edge nodes
        treeTraversal(root);


        //Q7 LevelOrder Traversal
        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);
    }

    static void levelOrderTraversal(Node rootNode) {
        //step1 - first oka queue ni initialize cheyali node generic
        //step2 - step1 lo create chesina queue ds lo input ga vochina root node ni add cheyali
        //step3 - while loop tho queu anedhi empty no kadho cheak chesi oka vela empty kakapotey
        //inside while loop ki enter avali
        //step4 - remove method use chesi queue lo vunna first node ni remove cheyali
        //print removed node data
        //remove chesina node ki children vunnayo levo check cheyali, oka vela children vuntey, ah
        //children ni queue lo add cheyali.

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(rootNode);

        while (queue.size() > 0) {
            Node removedNode = queue.remove();
            System.out.print(removedNode.data + " ");
            for (Node children : removedNode.children) {
                queue.add(children);
            }
        }
    }

    static void treeTraversal(Node rootNode) {
        System.out.println("pre node : " + rootNode.data);
        for (Node child : rootNode.children) {
            System.out.println("pre edge nodes : " + rootNode.data + "-->" + child.data);
            treeTraversal(child);
            System.out.println("post egde nodes :" + child.data + "-->" + rootNode.data);
        }
        System.out.println("post node : " + rootNode.data);
    }

    static int findHeightOfTree(Node root) {
        int height = -1;

        for (Node children : root.children) {
            int newHeight = findHeightOfTree(children);
            height = Math.max(height, newHeight);
        }
        height = height + 1;
        return height;
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
