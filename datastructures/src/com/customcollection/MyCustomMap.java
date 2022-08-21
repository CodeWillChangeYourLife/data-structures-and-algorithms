package com.customcollection;

import java.util.Objects;

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
        } else {
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
                        prev = temp;
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
                    System.out.print(temp.key + "--" + temp.value+" ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }

    boolean contains(K key) {
        if (key == null) {
            return false;
        }
        int index = Math.abs(key.hashCode() % size);

        if (table[index] == null) {
            return false;
        } else {
            Entry temp = table[index];

            while (temp != null) {
                if (temp.key.equals(key)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
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
        System.out.println(map.get(23));
        System.out.println(map.get(null));
        System.out.println(map.get(1000));
        System.out.println(map.contains(30));
        System.out.println(map.contains(null));
        System.out.println(map.contains(100));

        Product p1 = new Product(1, "Mobile1");
        Product p2 = new Product(2, "Laptop");
        Product p3 = new Product(3, "Tv");
        Product p4 = new Product(4, "Charger");
        Product p5 = new Product(1, "Mobile1");

        MyCustomMap<Product, Integer> productMap = new MyCustomMap<>();
        productMap.put(p1, 100);
        productMap.put(p2, 200);
        productMap.put(p3, 300);
        productMap.put(p4, 400);
        productMap.put(p5, 500);
        productMap.display();
    }
}

class Product {
    int productId;
    String productName;

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName);
    }

    @Override
    public String toString() {
        return "["+this.productId + " " + this.productName+"]";
    }
}