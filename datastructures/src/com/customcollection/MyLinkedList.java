package com.customcollection;

public class MyLinkedList<E>{
    Node head;
    Node tail;

    int size=0;


    public void add(E data){
        Node node = new Node(data,null);

        if(head==null){
            head=node;
            tail=node;
        }else{
            Node temp = head;

            while(temp.next !=null){
                temp=temp.next;
            }
            temp.next=node;
            tail=node;
        }

        size++;
    }

    public void displayLinkedList(){
        Node temp = head;

        while(temp !=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    class Node{
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.displayLinkedList();
    }
}
