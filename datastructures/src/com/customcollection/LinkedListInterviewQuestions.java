package com.customcollection;

public class LinkedListInterviewQuestions {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.display();
        //Interview Q1 Add First In LinkedList
        ll.addFirst(40);
        ll.display();
        //Interview Q2 Add Last In LinkedList
        ll.addLast(50);
        ll.display();
    }
}

class LinkedList<E> {
    Node head=null;
    Node tail=null;
    int size = 0;


    void add(E data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void addFirst(E e) {

        Node currentNode = new Node(e, null);
        if(head == null){
            head = currentNode;
            tail=currentNode;
        }else{
            currentNode.next=head;
            head=currentNode;
        }
        size++;
    }

    void addLast(E inputData) {
        Node currentNode = new Node(inputData,null);
        if(head==null){
            head=currentNode;
            tail=currentNode;
        }else{
           tail.next=currentNode;
           tail=currentNode;
        }
    }

    class Node {
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
