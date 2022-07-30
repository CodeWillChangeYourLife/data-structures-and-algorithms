package com.customcollection;

public class LinkedListInterviewQuestions {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.display();
        //Interview Q1 Add First Node In LinkedList
        ll.addFirst(40);
        ll.display();
        //Interview Q2 Add Last Node In LinkedList
        ll.addLast(50);
        ll.display();
        //Interview Q3 Remove First Node In LinkedList
        ll.removeFirst();
        ll.display();
        //Interview Q4 Remove Last Node In LinkedList
        ll.removeLast();
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
        int no = 100;
        while (temp.next != null) {
            System.out.print("| " + temp.data + " | " + no++ + " -|-" + "-->");
            temp = temp.next;
        }
        System.out.print("| " + temp.data + " | " + " null |");
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
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

    void removeFirst(){
        if(head==null){
            System.out.println("Lined List is Empty");
            return;
        }else{
            Node nextNode=head.next;
            head=nextNode;
            size--;
        }
    }

    void removeLast() {

        if(head==null){
            System.out.println("Linked List Is empty Remove is not possible");
            return;
        }else if(head.next==null){
            head =null;
            tail=null;
            size--;
        }else{
            Node temp = head;
            while(temp.next.next!=null){
                temp = temp.next;
            }
            temp.next=null;
            tail=temp;
            size--;
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
