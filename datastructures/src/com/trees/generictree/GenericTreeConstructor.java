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
        System.out.println();
        //Q8 Line Wise Level order traversal
        System.out.println("Level Order Line Wise Traversal");
        levelOrderLineWiseTraversal(root);

        //Q9 Zig Zag Traversal
        System.out.println("Zig Zag Traversal");
        zigZagTraversal(root);

        //Q10 Remove Leaf from the tree
        //removeLeafNodes(root);
        levelOrderLineWiseTraversal(root);

        //Q11 Search Node in a Tree
        boolean result = searchNodeInTree(root, 800);
        System.out.println(800 + " Node exist in Tree ? :" + result);
    }

    static boolean searchNodeInTree(Node rootNode, int data) {
        if (rootNode.data == data) {
            return true;
        }
        for (Node child : rootNode.children) {
            boolean result = searchNodeInTree(child, data);
            if (result) {
                return true;
            }
        }
        return false;
    }

    static void removeLeafNodes(Node rootNode) {
        for (int i = rootNode.children.size() - 1; i >= 0; i--) {
            Node node = rootNode.children.get(i);
            if (node.children.size() == 0) {
                rootNode.children.remove(node);
            }
        }
        for (Node child : rootNode.children) {
            removeLeafNodes(child);
        }
    }


    static void zigZagTraversal(Node rootNode) {
        //step1 - First two stacks objects create cheyali
        //step2 - first stack object lo input ga vochina root node ni add cheyali
        //step3 - while loop use chesi stack1 size zeero kantey ekkuva vunte in side while loop ki enter avali
        //stack1 lo top node ni remove chesi, ah tarvet remove chesina node ki children vuntey , dependes on level
        //stack2 lo ee chindren ni add cheyali
        //oka vela level kanuka odd number ayete normal for each loop or level kanuka even number ayete apudu manam children ni
        //right to left ki traverse chese stack 2 lo add cheyali
        //step3 - condition check -> oka vela mana stack1 size kanuka  zeero ayetey apudu manam stack2 ni stack1 ki assign cheyali
        //tarvata stack2 ki new object create cheyali

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(rootNode);
        int level = 1;
        while (s1.size() > 0) {
            Node removedNode = s1.pop();
            System.out.print(removedNode.data + " ");
            if (level % 2 != 0) {
                for (Node child : removedNode.children) {
                    s2.push(child);
                }
            } else {
                for (int i = removedNode.children.size() - 1; i >= 0; i--) {
                    s2.push(removedNode.children.get(i));
                }
            }
            if (s1.size() == 0) {
                s1 = s2;
                s2 = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    static void levelOrderLineWiseTraversal(Node rootNode) {
        //step1 - first two queue objects ni create cheyali generic vochesi <Node>
        //step2 - manam create chesina q1 lo input ga vochna root node ni add cheyali
        //step3 - while loop use chesi q1 object data anedi oka vela empty kakapotey apudu manam inside while loop ki enter avali
        //manam q1 lo add chesina node ni remove cheyali, tarvata remove chesina node data ni print cheyali
        //okavela remove chesina node ki kanuka children nodes vuntey apudu manam for each loop use chesi each children ni q2 lo add cheyali
        //last ki while loop lo oka condition implement cheyali
        // condition -> oka vela q1 size kanuka empty ayete or q1 size == 0 apudu mananm q2 object ni q1 ki assign cheyali
        //tarvata malli q2 ki new object create cheyali
        //final ga cursor ni new line ki point chese laga oka sop statement add cheyali

        Queue<Node> q1 = new ArrayDeque<>();
        Queue<Node> q2 = new ArrayDeque<>();

        q1.add(rootNode);

        while (q1.size() > 0) {
            Node removedNode = q1.remove();
            System.out.print(removedNode.data + " ");

            for (Node child : removedNode.children) {
                q2.add(child);
            }
            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new ArrayDeque<>();
                System.out.println();
            }
        }
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
