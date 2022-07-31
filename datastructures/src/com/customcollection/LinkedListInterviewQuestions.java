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
        ll.add(40);
        ll.display();
        //Interview Q5 Add Node At Specific Index In LinkedList
        ll.addNodeAt(0, 60);
        ll.display();
        //Interview Q6 Remove Node At Specific Index In LinkedList
        ll.removeNodeAt(4);
        ll.display();
        //Interview Q7 Reverse a LinkedList in Iterative Approach
        ll.reversLinkedList();
        ll.display();
        ll.addLast(65);
        ll.display();
    }
}

class LinkedList<E> {
    Node head = null;
    Node tail = null;
    int size = 0;

    void size() {
        System.out.println(size);
    }

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
        if (head == null) {
            head = currentNode;
            tail = currentNode;
        } else {
            currentNode.next = head;
            head = currentNode;
        }
        size++;
    }

    void addLast(E inputData) {
        Node currentNode = new Node(inputData, null);
        if (head == null) {
            head = currentNode;
            tail = currentNode;
        } else {
            tail.next = currentNode;
            tail = currentNode;
        }
        size++;
    }

    void removeFirst() {
        if (head == null) {
            System.out.println("Lined List is Empty");
            return;
        } else {
            Node nextNode = head.next;
            head = nextNode;
            size--;
        }
    }

    void removeLast() {

        if (head == null) {
            System.out.println("Linked List Is empty Remove is not possible");
            return;
        } else if (head.next == null) {
            head = null;
            tail = null;
            size--;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }
    }

    void addNodeAt(int targetIndex, E data) {
        if (targetIndex < 0) {
            System.out.println("Invalid Index");
            return;
        } else if (targetIndex >= size) {
            System.out.println("Invalid Index");
            return;
        }
        Node n1 = new Node(data, null);
        if (targetIndex == 0) {
            n1.next = head;
            head = n1;
        } else {
            Node current = head;
            for (int i = 0; i < targetIndex - 1; i++) {
                current = current.next;
            }
            Node backupNode = current.next;
            current.next = n1;
            n1.next = backupNode;
        }
        size++;
    }

    void removeNodeAt(int index) {
        if (index < 0) {
            System.out.println("Invald Index");
            return;
        } else if (index >= size) {
            System.out.println("Invalid Index");
            return;
        } else if (head == null) {
            System.out.println("Linked List is empty");
            return;
        } else if (index == 0) {
            Node node = head.next;
            head = node;
            size--;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node deleteNode = current.next;
            Node backupNode = deleteNode.next;
            current.next = backupNode;
            if (index == size - 1) {
                tail = current;
            }
            size--;
        }
    }

    void reversLinkedList() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        } else if (head.next == null) {
            System.out.println(head);
            return;
        } else {
            Node current = head;
            Node previous = null;
            Node next = null;
            tail = head;
            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            head = previous;
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
