package com.ds;

import java.util.Arrays;

public class ArrayList<E> {
    private Object[] elements;
    private int size = 10;
    private int index = 0;

    public ArrayList() {
        elements = new Object[size];
    }

    public void add(E data) {

        if (index == elements.length) {
            increaseCapacity();
        } else {
            elements[index++] = data;

        }
    }

    private void increaseCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void removeFirst() {
        if (elements.length < 1) {
            System.out.println("There are no elements in ArrayList");
            return;
        }
        int removedElement = (int) elements[0];
        for (int i = 0; i < index; i++) {
            elements[i] = elements[i + 1];
        }
        index--;
        System.out.println("Removed Element :" + removedElement);
    }


    public void removeLast() {
        if (elements.length < 1) {
            System.out.println("There are no elements in ArrayList");
            return;
        }
        int removedElement = (int) elements[index - 1];
        elements[index - 1] = null;
        index--;
        System.out.println("Removed Element :" + removedElement);
    }

    public void addAt(int inputIndex, E data) {
        if (inputIndex < 0 || inputIndex > size) {
            System.out.println("invalid index provided");
            return;
        }

        for (int i = index; i > inputIndex; i--) {
            elements[i] = elements[i - 1];
        }
        elements[inputIndex] = data;
        index++;
    }

    public void replaceAt(int inputIndex, E data) {
        if (inputIndex < 0 || inputIndex > size) {
            System.out.println("invalid index provided");
            return;
        }
        elements[inputIndex] = data;
    }

    public void sort() {

        if (elements.length < 1) {
            System.out.println("ArrayList is Empty");
            return;
        }
        //selection sort algorithm
        for (int i = 0; i < elements.length; i++) {
            int min = i;
            for (int j = i + 1; j < elements.length; j++) {
                if ((int) elements[j] < (int) elements[min]) {
                    min = j;
                }
            }
            int temp = (int) elements[i];
            elements[i] = elements[min];
            elements[min] = temp;
        }
    }

    public void displayArray() {
        for (int i = 0; i < index; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public void removeAt(int removeIndex) {
        if (removeIndex < 0) {
            System.out.println("Invalid Index Provided");
        }

        int removedElement = (int) elements[removeIndex];

        for (int i = removeIndex; i < index; i++) {
            elements[removeIndex] = elements[removeIndex + 1];
        }
        index--;
        System.out.println("Removed Element Is :" + removedElement);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.displayArray();
        list.removeFirst();
        list.displayArray();
        list.removeLast();
        list.displayArray();
        list.addAt(2, 200);
        list.displayArray();
        list.removeAt(3);
        list.displayArray();
        list.replaceAt(1, 300);
        list.displayArray();

    }
}
