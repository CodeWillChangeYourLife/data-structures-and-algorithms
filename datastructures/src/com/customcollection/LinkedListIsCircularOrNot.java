package com.customcollection;

public class LinkedListIsCircularOrNot {
    Node first = null;
    Node circularPoint1;
    Node circularPoint2;
    int size = 0;


    void addFirst(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            if (data == 50) {
                circularPoint1 = newNode;
            } else if (data == 55) {
                circularPoint2 = newNode;
            }
        }
    }

    void makeLinkedListCircular() {
        circularPoint2.next = circularPoint1;
    }

    void detectLoop() {
        Node slowPointer = first;
        Node fastPointer = first;

        while ((slowPointer != fastPointer || slowPointer == first) &&
                fastPointer.next != null && first.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        if (slowPointer == fastPointer) {
            System.out.println("Linked List is Circular");
        } else {
            System.out.println("Linked List is not Circular");
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    void display() {
        Node temp = first;
        int count = 1;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            count++;
            if (count == 10) break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListIsCircularOrNot ll = new LinkedListIsCircularOrNot();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addFirst(50);
        ll.addFirst(40);
        ll.addFirst(58);
        ll.addFirst(55);
        ll.addFirst(60);
        ll.display();
        ll.makeLinkedListCircular();
        ll.display();
        ll.detectLoop();
    }
}
