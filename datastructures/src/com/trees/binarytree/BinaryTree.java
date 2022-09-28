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
    //Algorithm STeps:
   // ae algorithm lo ayina sare first manake kavalsina variables ni algorithm starting lo declare chesukovali.
   // E algorithm lo naku oka rootNode , node, pair, stack of pairs  alage oka pointer array elements read cheyadaniki
   // kavali so vatini step1 lo declare chesa.
   // second step lo manaki input ga vochina array lo oth index lo vunna value ni read chesi node object create chesi
   // danini rootnode ki assign chesa,
   // tarvata pair object create chesi andhulo manam create chesina root node alage state 1

    //step2 final vochi ee pair ni stack pairs object lo push cheyali

    //Step3 vochi main algorithm , endhulo manam oka while loop tisukovali condition vochesi ,
    // mana stack size anedhi zeero ayyevaraku loop continue cheyali epudite stack size zeero avudho
    // apudu manam loop nunchi exit avali

    //Step4 lo actual algorithm logic implement cheyali
    //First manam stack lo vunna top pair ni get cgesukoni ah pair state basic 3 vuntaye state1, state2, state3.
    //state1 ayete epudu manam input array data read cheyali
    //read chesina tarvuta ah data kanuka null kakapotey apudu manam node create cheyali ee data tho,
    // tarvata ee node ni mana toppair lo vunna node ki left node ga mana new node ni add chestam tarvata
    // oka new pair object create chesi, ah pair lo e new node ni state 1 ga add chesi , pairs stack lo push cheyeli,
    // else data null ayete apudu top pair node ki left lo null add cheyali, final ga top pair state ni
    // 1 increment cheyali endhukantey next voche node top node ki right lo matramey add avali kabatti
    //oka vela state 2 ayete state1 lo lage same process kakapotey epudu toppair node ki right side add
    // cheyali either node or null.
    //FInal ga state kanuka 3 ayete apudu manam pairs stack lo top pair no remove cheyali pairs.pop() method call chesi.
    static Node constructBinaryTree(Integer[] inputArray) {
        //Step1
        Node rootNode = null;
        Pair pair = null;
        Node node = null;
        Stack<Pair> pairs = new Stack<>();
        rootNode = new Node(inputArray[0]);
        pair = new Pair(rootNode, 1);
        //step2
        pairs.push(pair);
        int index = 0;
        //step3
        while (pairs.size() > 0) {
            //step4
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