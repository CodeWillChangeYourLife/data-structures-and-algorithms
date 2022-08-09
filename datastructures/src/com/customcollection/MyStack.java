package com.customcollection;

import java.util.Stack;

public class MyStack<E>{
    Object[] elements;
    int top = -1;

    MyStack(){
        elements= new Object[5];
    }

    void push(E data){
        if(top == elements.length-1){
            System.out.println("Stack is full");
        }else{
            elements[++top] = data;
        }
    }

    void display(){
        for(int i=0;i<=top;i++){
            System.out.println(elements[i]);
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
      //  stack.push(40);
      //  stack.push(50);
        stack.display();
    }

}
