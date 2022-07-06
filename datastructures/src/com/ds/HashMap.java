package com.ds;

public class HashMap<K, V> {
    private Entry[] table;
    private int size = 16;

    public HashMap() {
        table = new Entry[size];
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K newKey, V value) {
        if (newKey == null) {
            System.out.println("Null is noy allowed as a Key");
            return;
        }
        int index = findBucketIndex(newKey);
        Entry newEntry = new Entry(newKey, value, null);
        if (table[index] == null) {
            table[index] = newEntry;
            return;
        }
        Entry current = table[index];
        Entry previous = null;

        while (current != null) {
            if (current.key.equals(newEntry.key)) {
                if (previous == null) {
                    newEntry.next = table[index].next;
                    table[index] = newEntry;
                    return;
                }
                newEntry.next = current.next;
                previous.next = newEntry;
                return;
            }
            previous = current;
            current = current.next;
        }
        previous.next = newEntry;
    }

    public void display() {

        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                Entry current = table[i];

                while (current != null) {
                    System.out.println(current.key + "---" + current.value);
                    current = current.next;
                }
            }
        }
        System.out.println();
    }

    public void remove(K deleteKey) {
        if (deleteKey == null) {
            System.out.println("Null key not allowed to delete");
            return;
        }

        int index = findBucketIndex(deleteKey);
        if (table[index] == null) {
            System.out.println("Key is not exist");
            return;
        }

        Entry previous = null;
        Entry current = table[index];

        while (current != null) {
            if (current.key.equals(deleteKey)) {
                if (previous == null) {
                    table[index] = table[index].next;
                    System.out.println(current.key + "---" + current.value + " deleted from the map successfully");
                    return;
                }
                previous.next = current.next;
                System.out.println(current.key + "---" + current.value + " deleted from the map successfully");
                return;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Key is not exist in map");
    }

    private int findBucketIndex(K key) {
    return Math.abs(key.hashCode()%size);
    }

    public boolean contains(K newKey) {
        if (newKey == null) {
            return false;
        }
        int index = findBucketIndex(newKey);
        if (table[index] == null) {
            return false;
        }

        Entry current = table[index];

        while (current != null) {
            if (current.key.equals(newKey)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(10, "Hari");
        map.put(20, "HariNadh");
        map.put(30, "Bhadrachalam");
        map.put(40, "Khammam");

        map.display();

        map.remove(10);
        System.out.println();
        map.display();

       /* for(int i =10;i<9999;i++){
            map.put(i, "sasa");
        }*/

        java.util.HashMap<Integer, String> ma = new java.util.HashMap();

        ma.put(10, "Hari");
        ma.put(20, "HariNadh");
        ma.put(30, "ABC");
        ma.put(40, "Def");

        System.out.println("added");

        map.display();
    }

}
