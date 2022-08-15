package com.customcollection;

public class MyQueue<E> {
    Object[] elements = new Object[10];
    int first = -1;
    int last = -1;

    void enQueue(E data) {
        if (elements.length == last) {
            System.out.println("Queue is Full");
            return;
        }
        if (first == -1) {
            elements[++first] = data;
            last++;
        } else {
            elements[++last] = data;
        }
    }

    void deQueue() {
        E data = (E) elements[first];
        System.out.println(data);
        for (int i = 0; i <= last; i++) {
            elements[i] = elements[i + 1];
        }
        --last;
    }

    void display() {
        for (int i = first; i <= last; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>();
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.display();
        q.deQueue();
        q.display();
        q.enQueue(50);
        q.display();
        q.deQueue();
        q.deQueue();
        q.display();
        q.enQueue(100);
        q.display();
    }
}
