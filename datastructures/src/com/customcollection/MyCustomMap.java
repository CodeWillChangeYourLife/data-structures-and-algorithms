package com.customcollection;

public class MyCustomMap<K, V> {
    Entry[] table;
    int size = 4;

    class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    MyCustomMap() {
        table = new Entry[size];
    }

    void put(K newKey, V newValue) {
        if (newKey == null) {
            return;
        }
        Entry entry = new Entry(newKey, newValue, null);

        int index = Math.abs(newKey.hashCode() % size);

        if (table[index] == null) {
            table[index] = entry;
            return;
        } else {
            Entry temp = table[index];
            Entry prev = null;

            while (temp != null) {
                if (temp.key.equals(newKey)) {
                    if (prev == null) {
                        temp.value = newValue;
                        return;
                    } else {
                        entry.next = temp.next;
                        prev.next = entry;
                        return;
                    }
                } else {
                    prev = temp;
                    temp = temp.next;
                }
            }
            prev.next = entry;
        }
    }

    V get(K key) {
        if (key == null) {
            return null;
        }
        int index = Math.abs(key.hashCode() % size);
        if (table[index] == null) {
            return null;
        } else {
            Entry temp = table[index];

            while (temp != null) {
                if (temp.key.equals(key)) {
                    return (V) temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    boolean remove(K key) {
        if (key == null) {
            return false;
        } else {
            int index = Math.abs(key.hashCode() % size);
            if (table[index] == null) {
                return false;
            } else {
                Entry temp = table[index];
                Entry prev = null;

                while (temp != null) {
                    if (temp.key.equals(key)) {
                        if (prev == null) {
                            table[index] = table[index].next;
                            return true;
                        } else {
                            prev.next = temp.next;
                            return true;
                        }
                    } else {
                        prev=temp;
                        temp = temp.next;
                    }
                }
            }
        }
        return false;
    }

    void display() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry temp = table[i];

                while (temp != null) {
                    System.out.print(i + "--" + temp.key + "--" + temp.value + "  ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        MyCustomMap<Integer, Integer> map = new MyCustomMap<>();
        map.put(21, 200);
        map.put(30, 300);
        map.put(31, 400);
        map.put(35, 500);
        map.put(23, 600);

        map.display();
        map.put(35, 900);
        System.out.println("-----------------------");
        map.display();
        System.out.println(map.remove(35));
        System.out.println("-----");
        map.display();

    }
}
