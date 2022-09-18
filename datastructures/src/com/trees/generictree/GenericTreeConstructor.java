package com.trees.generictree;

import java.util.*;

public class GenericTreeConstructor {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) {
        int data;
        int[] arr1 = {10, 20, 50, -1, 90, -1, -1, 30, 70, -1, 80, -1, -1, 40, 60, -1, -1, -1};
        int[] arr2 = {10, 20, 50, -1, 90, 200, -1, 300, -1, -1, -1, 30, 70, -1, 80, -1, -1, 40, 60, -1, -1, -1};
        int[] arr3 = {10, 20, 50, -1, 90, -1, -1, 30, 70, -1, 80, -1, -1, 40, 60, -1, -1, -1};
        Node tree1 = null;
        Node tree2 = null;
        Node tree3 = null;
        //Q1 Construct Generic Tree from the input array data
        tree1 = constructTree(arr1, tree1);
        tree2 = constructTree(arr2, tree2);
        tree3 = constructTree(arr3, tree3);

        System.out.println("Display Tree 2");
        displayTree(tree2);
        System.out.println("--------------");
        //Q2 Display a Constructed Generic Tree
        displayTree(tree1);

        //Q3 Find node count in a Generic Tree
        int noOfNodes = countNoOfNodesInTree(tree1);
        System.out.println("Number Of Nodes In Tree : " + noOfNodes);

        //Q4 Find the max node in a tree
        Node maxNode = findMaxNode(tree1);
        System.out.println("Max Node In A Tree : " + maxNode.data);

        //Q5 Find the height of a given tree
        int treeHeight = findHeightOfTree(tree1);
        System.out.println("Tree Height : " + treeHeight);

        //Q6 Traverse the tree with pre node, post node , pre edge nodes and post edge nodes
        treeTraversalWithPreAndPostNodes(tree1);

        //Q7 LevelOrder Traversal
        System.out.println("Level Order Traversal");
        levelOrderTraversal(tree1);
        System.out.println();
        //Q8 Line Wise Level order traversal
        System.out.println("Level Order Line Wise Traversal");
        levelOrderLineWiseTraversal(tree1);

        //Q9 Zig Zag Traversal
        System.out.println("Zig Zag Traversal");
        zigZagTraversal(tree1);

        //Q10 Remove Leaf from the tree
        //removeLeafNodes(tree1);
        levelOrderLineWiseTraversal(tree1);

        //Q11 Search Node in a Tree
        boolean result = searchNodeInTree(tree1, 800);
        System.out.println(800 + " Node exist in Tree ? :" + result);
        int nodeData = 80;
        List<Integer> list = nodeTotree1Path(tree1, nodeData);
        System.out.println("Node to tree1 Path");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        //Q13 - The Lowest common ancestor for given two nodes
        lowestCommonAncestor(tree2, 50, 300);

        //Q14 - Distance between two nodes
        int distance = distanceBetweenTwoNodes(tree1, 50, 60);
        System.out.println("Distance between two nodes " + distance);

        //Q15 - Two trees similar in shape or not
        boolean treesAreSame = twoTreesSimilarInShape(tree1, tree2);
        System.out.println("tress are same :" + treesAreSame);

        //Q16 జావా లో టూ trees same in mirror ela find cheyali ?
        boolean treesMirror = twoTreesSameInMirror(tree1, tree3);
        System.out.println("Two Trees mirror in shape :" + treesMirror);
    }

    static boolean twoTreesSameInMirror(Node tree1, Node tree2) {

        if (tree1 == null || tree2 == null) {
            return false;
        } else if (tree1.children.size() != tree2.children.size()) {
            return false;
        }
        for (int i = 0; i < tree1.children.size(); i++) {
            int j = tree2.children.size() - 1 - i;
            Node c1 = tree1.children.get(i);
            Node c2 = tree2.children.get(j);
            if (twoTreesSameInMirror(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }


    static boolean twoTreesSimilarInShape(Node tree1, Node tree2) {
        if (tree1 == null || tree2 == null) {
            return false;
        } else if (tree1.children.size() != tree2.children.size()) {
            return false;
        }

        for (int i = 0; i < tree1.children.size(); i++) {
            Node c1 = tree1.children.get(i);
            Node c2 = tree2.children.get(i);
            if (twoTreesSimilarInShape(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }

    static int distanceBetweenTwoNodes(Node tree1Node, int data1, int data2) {
        List<Integer> list1 = nodeTotree1Path(tree1Node, data1);
        List<Integer> list2 = nodeTotree1Path(tree1Node, data2);

        int p1 = list1.size() - 1;
        int p2 = list2.size() - 1;

        while (p1 >= 0 && p2 >= 0 && list1.get(p1) == list2.get(p2)) {
            list1.remove(p1);
            list2.remove(p2);
            p1--;
            p2--;
        }
        return list1.size() + list2.size();
    }

    static void lowestCommonAncestor(Node tree1Node, int data1, int data2) {

        List<Integer> list1 = nodeTotree1Path(tree1Node, data1);
        List<Integer> list2 = nodeTotree1Path(tree1Node, data2);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        while (i >= 0 && j >= 0 && list1.get(i) == list2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        System.out.println("Lowest common ancestor for given data1 " + data1 + " and " + data2 + " :" + list1.get(i));
    }


    static List<Integer> nodeTotree1Path(Node tree1Node, int data) {
        if (tree1Node.data == data) {
            List<Integer> list = new ArrayList<>();
            list.add(tree1Node.data);
            return list;
        }
        for (Node child : tree1Node.children) {
            List<Integer> result = nodeTotree1Path(child, data);
            if (result.size() > 0) {
                result.add(tree1Node.data);
                return result;
            }
        }
        return new ArrayList<>();
    }

    static boolean searchNodeInTree(Node tree1Node, int data) {
        if (tree1Node.data == data) {
            return true;
        }
        for (Node child : tree1Node.children) {
            boolean result = searchNodeInTree(child, data);
            if (result) {
                return true;
            }
        }
        return false;
    }

    static void removeLeafNodes(Node tree1Node) {
        for (int i = tree1Node.children.size() - 1; i >= 0; i--) {
            Node node = tree1Node.children.get(i);
            if (node.children.size() == 0) {
                tree1Node.children.remove(node);
            }
        }
        for (Node child : tree1Node.children) {
            removeLeafNodes(child);
        }
    }


    static void zigZagTraversal(Node tree1Node) {
        //step1 - First two stacks objects create cheyali
        //step2 - first stack object lo input ga vochina tree1 node ni add cheyali
        //step3 - while loop use chesi stack1 size zeero kantey ekkuva vunte in side while loop ki enter avali
        //stack1 lo top node ni remove chesi, ah tarvet remove chesina node ki children vuntey , dependes on level
        //stack2 lo ee chindren ni add cheyali
        //oka vela level kanuka odd number ayete normal for each loop or level kanuka even number ayete apudu manam children ni
        //right to left ki traverse chese stack 2 lo add cheyali
        //step3 - condition check -> oka vela mana stack1 size kanuka  zeero ayetey apudu manam stack2 ni stack1 ki assign cheyali
        //tarvata stack2 ki new object create cheyali

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(tree1Node);
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

    static void levelOrderLineWiseTraversal(Node tree1Node) {
        //step1 - first two queue objects ni create cheyali generic vochesi <Node>
        //step2 - manam create chesina q1 lo input ga vochna tree1 node ni add cheyali
        //step3 - while loop use chesi q1 object data anedi oka vela empty kakapotey apudu manam inside while loop ki enter avali
        //manam q1 lo add chesina node ni remove cheyali, tarvata remove chesina node data ni print cheyali
        //okavela remove chesina node ki kanuka children nodes vuntey apudu manam for each loop use chesi each children ni q2 lo add cheyali
        //last ki while loop lo oka condition implement cheyali
        // condition -> oka vela q1 size kanuka empty ayete or q1 size == 0 apudu mananm q2 object ni q1 ki assign cheyali
        //tarvata malli q2 ki new object create cheyali
        //final ga cursor ni new line ki point chese laga oka sop statement add cheyali

        Queue<Node> q1 = new ArrayDeque<>();
        Queue<Node> q2 = new ArrayDeque<>();

        q1.add(tree1Node);

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

    static void levelOrderTraversal(Node tree1Node) {
        //step1 - first oka queue ni initialize cheyali node generic
        //step2 - step1 lo create chesina queue ds lo input ga vochina tree1 node ni add cheyali
        //step3 - while loop tho queu anedhi empty no kadho cheak chesi oka vela empty kakapotey
        //inside while loop ki enter avali
        //step4 - remove method use chesi queue lo vunna first node ni remove cheyali
        //print removed node data
        //remove chesina node ki children vunnayo levo check cheyali, oka vela children vuntey, ah
        //children ni queue lo add cheyali.

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(tree1Node);

        while (queue.size() > 0) {
            Node removedNode = queue.remove();
            System.out.print(removedNode.data + " ");
            for (Node children : removedNode.children) {
                queue.add(children);
            }
        }
    }

    static void treeTraversalWithPreAndPostNodes(Node tree1Node) {
        System.out.println("pre node : " + tree1Node.data);
        for (Node child : tree1Node.children) {
            System.out.println("pre edge nodes : " + tree1Node.data + "-->" + child.data);
            treeTraversalWithPreAndPostNodes(child);
            System.out.println("post egde nodes :" + child.data + "-->" + tree1Node.data);
        }
        System.out.println("post node : " + tree1Node.data);
    }

    static int findHeightOfTree(Node tree1) {
        int height = -1;

        for (Node children : tree1.children) {
            int newHeight = findHeightOfTree(children);
            height = Math.max(height, newHeight);
        }
        height = height + 1;
        return height;
    }

    static int countNoOfNodesInTree(Node tree1) {
        //step1 - first oka varible ni create chesi assign 0 as value
        //step2 - input vochina tree1 node ni children read chesi recursive ga countNoOfNodesInTree method ni call cheyali
        //step3 - return chese mundu add +1 to the size

        int size = 0;

        for (Node cn : tree1.children) {
            int cnSize = countNoOfNodesInTree(cn);
            size = cnSize + size;
        }
        return size + 1;
    }

    static Node findMaxNode(Node tree1) {
        //step1- vochina tree1 node ni max noda ga assume chesukovali
        //step2- for each loop use chesi anni nodes traversa cheyali recursive ga
        //step3 - for each loop lopala logic -> evry node data ni manam initial ga assume chesukunna
        //maxNode data tho compare cheyali oka vela , manam assume chesukunna maxnode data kantey
        // for each loop lo vochina node data ekkuva vuntey apudu foreach lo vunna node ni maxNoda
        // ki assign cheyali,same stepa anni nodes ki follow avali
        //Step4: Final ga maxNode ni return cheyali

        //Code
        //step1
        Node maxNode = tree1;

        for (Node child : tree1.children) {
            Node currentMax = findMaxNode(child);
            if (currentMax.data > maxNode.data) {
                maxNode = currentMax;
            }
        }
        return maxNode;
    }

    //data->children data
    static void displayTree(Node tree1) {
        System.out.print(tree1.data + " --> ");
        for (Node children : tree1.children) {
            System.out.print(children.data + " ");
        }
        System.out.println();

        for (Node children : tree1.children) {
            displayTree(children);
        }
    }

    static Node constructTree(int[] array, Node tree1) {
        //step1 - Create a Stack with Node
        //step2 - traverse the input array
        //step3 - check each index value , if value = -1 , remove data from the stack, okavela -1 kadhu
        // Node create chesi , ah node ki manam array nunchi read chesina data ni set cheyali
        // check stack is empty or not if it is empty assign the created node into tree1 node , if
        // get the top node from the stack and get chesukunna node children ki mana node ni add cheyali

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                stack.pop();
            } else {
                Node node = new Node();
                node.data = array[i];
                if (stack.isEmpty()) {
                    tree1 = node;
                } else {
                    stack.peek().children.add(node);
                }
                stack.push(node);
            }
        }
        System.out.println(stack.isEmpty());
        return tree1;
    }
}
