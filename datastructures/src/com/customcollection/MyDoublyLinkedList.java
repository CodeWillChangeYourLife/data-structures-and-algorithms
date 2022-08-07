package com.customcollection;

public class MyDoublyLinkedList<E> {
    Node first = null;
    Node last = null;
    int size = 0;

    class Node {
        Node prev;
        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    void add(E data) {
        Node n1 = new Node(data);
        if (first == null) {
            first = n1;
            last = n1;
        } else {
            last.next = n1;
            n1.prev = last;
            last = n1;
        }
        size++;
    }

    void addFirst(E data) {
        Node n1 = new Node(data);
        if (first == null) {
            first = n1;
            last = n1;
        } else {
            n1.next = first;
            first.prev = n1;
            first = n1;
        }
        size++;
    }

    void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void size() {
        System.out.println(size);
    }

    void removeFirst() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        } else if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }


    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> ll = new MyDoublyLinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.display();
        ll.size();
        ll.addFirst(100);
        ll.display();
        ll.size();
        ll.removeFirst();
        ll.display();
        ll.size();
        ll.addFirst(200);
        ll.display();
    }
}