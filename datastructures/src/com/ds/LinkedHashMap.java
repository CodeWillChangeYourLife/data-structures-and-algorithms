package com.ds;

public class LinkedHashMap<K, V> {
    Node<K, V> head;
    Node<K, V> tail;
    Node<K, V>[] table;
    int size = 4;

    public LinkedHashMap() {
        table = new Node[size];
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> before;
        Node<K, V> after;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K key, V value) {
        if (key == null) {
            System.out.println("Null key not allowed");
            return;
        }
        Node<K, V> newNode = new Node<>(key, value, null);
        int index = Math.abs(key.hashCode() % size);
        maintainInsertionOrderAfterInsertion(newNode);
        if (table[index] == null) {
            table[index] = newNode;
            return;
        }
        Node<K, V> previous = null;
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(newNode.key)) {
                if (previous == null) {
                    newNode.next = current.next;
                    table[index] = newNode;
                    return;
                }
                newNode.next = current.next;
                previous.next = newNode;
                return;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (previous != null) {
            previous.next = newNode;
        }
    }

    private void maintainInsertionOrderAfterInsertion(Node<K, V> newNode) {

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else if (head.key.equals(newNode.key)) {
            deleteFirst();
            insertFirst(newNode);
            return;
        } else if (tail.key.equals(newNode.key)) {
            deleteLast();
            insertLast(newNode);
            return;
        }

        Node beforeDeleteNode = deleteSpecificNode(newNode);

        if (beforeDeleteNode == null) {
            insertLast(newNode);
            return;
        }
        insertAfter(beforeDeleteNode, newNode);
    }

    private void insertAfter(Node beforeDeleteNode, Node<K, V> newNode) {

        newNode.after = beforeDeleteNode.after;
        beforeDeleteNode.after.before = newNode;
        beforeDeleteNode.after = newNode;
        newNode.before = beforeDeleteNode;
    }

    private Node deleteSpecificNode(Node<K, V> newNode) {
        Node current = head;

        while (!(current.key.equals(newNode.key))) {
            if (current.next == null) {
                return null;
            }
            current = current.after;
        }
        Node beforeDelete = current.before;
        beforeDelete.after = current.after;
        beforeDelete.after.before = beforeDelete;
        return beforeDelete;
    }

    private void deleteLast() {
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.before;
        tail.after = null;
    }

    private void insertLast(Node<K, V> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.after = newNode;
        newNode.before = tail;
        tail = newNode;
    }

    private void insertFirst(Node<K, V> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.after = head;
        head.before = newNode;
        head = newNode;
    }

    private void deleteFirst() {
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        head = head.after;
        head.before = null;
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.key + "--->" + current.value + " ");
            current = current.after;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> lm = new LinkedHashMap<>();
        lm.put(20, "hari");
        lm.put(10, "bcm");
        lm.put(40, "khammam");
        lm.put(30, "andhrapradesh");

        lm.put(20, "kokila");

        lm.put(30, "tamilnadu");

        lm.put(40, "chennai");

        lm.display();
    }
}
