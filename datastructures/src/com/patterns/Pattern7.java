package com.patterns;

/*1
  2  3
  4  5  6
  7  8  9 10
  11 12 13 14 15*/
public class Pattern7 {

    public static void main(String[] args) {
        int no = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(no + " ");
                no++;
            }
            System.out.println();
        }
    }
}
