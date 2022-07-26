package com.customcollection;

public class MyLinkedList<E> {
    Node head = null;
    Node tail = null;

    int size = 0;

    public void add(E data) {
        Node node = new Node(data, null);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            tail = node;
        }

        size++;
    }


    void addFirst(E e) {

        Node n1 = new Node(e, null);

        if (head == null) {
            head = n1;
            tail = n1;
        } else {
            n1.next = head;
            head = n1;
        }
        size++;
    }

    void remveFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            Node next = head.next;
            head = next;
            size--;
        }
    }


    public void removeLast() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void removeFirst() {
        Node temp = head.next;
        head = temp;
        size--;
    }

    void getValueAt(int index) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        } else if (index < 0 || index > size) {
            System.out.println("Invalid Index is received");
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }

    public void displayLinkedList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void reverseLinkedList() {
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    void getFirst() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        } else {
            System.out.println(head.data);
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

    void size() {
        System.out.println(size);
    }

    void getLast() {
        if (tail == null) {
            System.out.println("Linked List is Empty");
            return;
        } else {
            System.out.println(tail.data);
        }
    }

    public static void main(String[] args) {

        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.displayLinkedList();
        ll.addFirst(50);
        ll.displayLinkedList();
        ll.size();
        ll.removeFirst();
        ll.displayLinkedList();
        ll.size();
        ll.getValueAt(-9);
        ll.getFirst();
    }
}
