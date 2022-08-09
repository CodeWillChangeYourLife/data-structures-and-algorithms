package com.customcollection;

import java.util.Stack;

public class MyStack<E> {
    Object[] elements;
    int top = -1;

    MyStack() {
        elements = new Object[6];
    }

    void push(E data) {
        if (top == elements.length - 1) {
            System.out.println("Stack is full");
        } else {
            elements[++top] = data;
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack is empty removal not possible");
        } else {
            System.out.println("Removed data from stack " + elements[top]);
            top--;
        }
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFull() {
        if (top == elements.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(elements[i]);
        }
    }

    E peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return (E) elements[top];
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();
        stack.pop();
        System.out.println("-----");
        stack.display();
        stack.push(100);
        System.out.println("----------");
        stack.display();
        System.out.println("-----------");
        stack.push(200);
        stack.display();
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.peek());
        System.out.println("------------");
        stack.display();
    }

}
