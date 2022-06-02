package com.ds;

public class LinkedList<K> {
    private Node head;
    private Node tail;
    private static int size = 0;

    class Node {
        K data;
        Node next;

        public Node(K data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void add(K data) {
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

    public void addFirst(K data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    public void remove(K data) {
        if (data == null) {
            System.out.println("Null should not allowed");
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.data.equals(data)) {
                if (previous == null) {
                    head = current.next;
                    size--;
                    return;
                } else {
                    previous.next = current.next;
                    size--;
                    return;
                }
            }
            previous = current;
            current = current.next;
        }
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("==========================");
    }

    public void addAt(int index, K data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid Index");
        } else {
            Node current = head;
            Node newNode = new Node(data, null);
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void replaceAt(int index, K data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid Index given");
            return;
        }
        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(data, null);
        if (size - index > 2) {
            newNode.next = current.next.next;
            current.next = newNode;
        } else {
            current.next = newNode;
        }
    }

    public void size() {
        System.out.println(size);
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.display();
        ll.addFirst(100);
        ll.display();
        ll.remove(30);
        ll.display();
        ll.size();
        ll.addAt(2, 200);
        ll.display();
        ll.size();
        ll.replaceAt(2, 300);
        ll.display();
        ll.size();
        System.out.println("Adding");
        for(int i=0;i<20000000;i++){
            ll.add(i);
        }
        
        System.out.println("Ended");

        ll.display();
    }
}
