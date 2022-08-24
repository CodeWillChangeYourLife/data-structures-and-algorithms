package com.customcollection;

public class MyLinkedHashMap<K, V> {
    Entry[] table;
    int capacity = 4;
    Entry first;
    Entry last;

    class Entry<K, V> {
        K key;
        V value;
        Entry next;
        Entry before;
        Entry after;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    MyLinkedHashMap() {
        table = new Entry[capacity];
    }

    void put(K key, V value) {
        if (key == null) {
            return;
        }
        Entry entry = new Entry(key, value);
        int index = Math.abs(key.hashCode() % capacity);
        maintainInsertionOrder(entry);
        if (table[index] == null) {
            table[index] = entry;
        }
        Entry prev = null;
        Entry current = table[index];

        while (current != null) {
            if (current.key.equals(entry.key)) {
                current.value = entry.value;
                return;
            }
            prev = current;
            current = current.next;
        }
        prev.next = entry;
    }

    void maintainInsertionOrder(Entry newEntry) {
        if (first == null) {
            first = newEntry;
            last = newEntry;
            return;
        } else if (first.key.equals(newEntry.key)) {
            first.value = newEntry.value;
            return;
        } else if (last.key.equals(newEntry.value)) {
            last.value = newEntry.value;
            return;
        }
        Entry temp = first.after;
        while (temp != null) {
            if (temp.key.equals(newEntry.key)) {
                temp.value = newEntry.value;
                return;
            }
            temp = temp.next;
        }
        last.after = newEntry;
        newEntry.before = last;
        last = newEntry;
    }

    void display() {
        Entry temp = first;
        while (temp != null) {
            System.out.print(temp.key + " -- " + temp.value + "  ");
            temp = temp.after;
        }
        System.out.println();
    }

    boolean remove(K key) {
        if (key == null) {
            return false;
        }
        int index = Math.abs(key.hashCode() % capacity);

        if (table[index] == null) {
            return false;
        }
        Entry prev = null;
        Entry temp = table[index];

        while (temp != null) {
            if (temp.key.equals(key)) {
                maintainOrderAfterRemoving(key);
                if (prev == null) {
                    table[index] = table[index].next;
                    return true;
                } else {
                    prev.next = temp.next;
                    return true;
                }
            }
            prev = temp;
            temp = temp.next;
        }
        return false;
    }

    void maintainOrderAfterRemoving(K deleteKey) {
        if (first == null) {
            return;
        } else if (first.key.equals(deleteKey)) {
            if (first == last) {
                first = null;
                last = null;
                return;
            } else {
                first = first.after;
                first.before = null;
                return;
            }
        } else if (last.key.equals(deleteKey)) {
            last = last.before;
            last.after = null;
            return;
        }
        Entry temp = first.after;
        while (temp != null) {
            if (temp.key.equals(deleteKey)) {
                temp.after.before = temp.before;
                temp.before.after = temp.after;
                return;
            }
            temp = temp.next;
        }
    }

    boolean contains(K key) {

        if (key == null) {
            return false;
        }
        int index = Math.abs(key.hashCode() % capacity);
        if (table[index] == null) {
            return false;
        }
        Entry temp = table[index];

        while (temp != null) {
            if (temp.key.equals(key)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    V get(K key) {
        if (key == null) {
            return null;
        }
        int index = Math.abs(key.hashCode() % capacity);
        if (table[index] == null) {
            return null;
        }
        Entry temp = table[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return (V) temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyLinkedHashMap<Integer, Integer> ll = new MyLinkedHashMap();
        ll.put(10, 100);
        ll.put(30, 300);
        ll.put(20, 200);
        ll.put(40, 400);

        ll.display();
        ll.remove(30);
        ll.display();
        System.out.println(ll.contains(20));
        System.out.println(ll.contains(30));
        ll.remove(10);
        ll.display();
        ll.put(100, 399);
        ll.display();
        System.out.println(ll.get(203));
        System.out.println(ll.get(100));
        System.out.println(ll.get(40));
    }
}
