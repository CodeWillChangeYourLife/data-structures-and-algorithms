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

    void removeLast() {
        if (first == null) {
            System.out.println("DoublyLinkedList is empty");
            return;
        } else if (first.next == null) {
            first = null;
            last = null;
            size--;
            return;
        }
        last = last.prev;
        last.next = null;
        size--;
    }

    void removeAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid Index");
            return;
        } else if (first == null) {
            System.out.println("List is empty");
            return;
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
        }
    }

    void addAt(int index, E data) {
        Node n1 = new Node(data);
        if (first == null) {
            first = n1;
            last = n1;
        } else if (index == 0) {
            addFirst(data);
        } else if (index == size - 1) {
            add(data);
        } else {
            Node temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node previous = temp.next;
            n1.next = previous;
            previous.prev = n1;
            temp.next = n1;
            n1.prev = temp;
            size++;
        }
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
        ll.removeLast();
        ll.display();
        ll.add(33);
        ll.display();
        ll.removeAt(5);
        ll.display();
        ll.add(55);
        ll.display();
        ll.addAt(2, 90);
        ll.display();
    }
}