package com.customcollection;

public class MyArrayList<E> {
    Object[] data;
    int index=0;

    MyArrayList(){
        data=new Object[10];
    }

    public void addFirst(E e){

        for(int i=index;i>0;i--){
            data[i]=data[i-1];
        }
        data[0]=e;
        index++;
    }

    public void removeFirst(){
        for(int i=0;i<index;i++){
            data[i]=data[i+1];
        }
        index--;
    }
    public void size(){
        System.out.println(index);
    }
    void add(E e){
        if(index==data.length){
            increaseArrayCapacity();
            data[index]=e;
        }else{
           data[index]=e;
        }
        index++;
    }

    public void display(){
        for(int i=0;i<index;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    private void addAt(int inputIndex, E e) {
        for(int i=index;i>inputIndex;i--){
            data[i]=data[i-1];
        }
        data[inputIndex]=e;
        index++;
    }

    public void replace(int inputIndex, E e){
        data[inputIndex]=e;
    }


    private void increaseArrayCapacity() {
        int newSize=data.length*2;
        Object[] newArray = new Object[newSize];
        for(int i=0;i<data.length;i++){
            newArray[i]=data[i];
        }
        data = newArray;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.display();
        al.size();
        al.addFirst(100);
        al.display();
        al.size();
        al.removeFirst();
        al.display();
        al.size();
        al.addAt(1,200);
        al.display();
        al.size();
        al.replace(1,300);
        al.display();
        al.size();

        MyArrayList<String> al1 = new MyArrayList<>();
        al1.add("John");
        al1.add("Scott");
        al1.add("Miller");
        al1.add("Clerk");
        al1.add("Shyam");
        
        al1.display();
        al1.size();

        MyArrayList al2 = new MyArrayList();
        al2.add("Miller");
        al2.add(100);
        al2.add("King");
        al2.add(true);
        al2.add(1234.54);

        al2.display();
        al2.size();
    }
}
