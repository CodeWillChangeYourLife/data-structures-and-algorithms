package com.patterns;

/* 54321
   5432
   543
   54
   5*/
public class Pattern5 {

    public static void main(String[] args) {

        for (int i = 5; i > 0; i--) {
            int no = 5;
            for (int j = 0; j < i; j++) {
                System.out.print(no + " ");
                no--;
            }
            System.out.println();
        }
    }
}
