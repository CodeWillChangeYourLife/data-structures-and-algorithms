package com.patterns;

/*      54321
        4321
        321
        21
        1  */
public class Pattern6 {

    public static void main(String[] args) {

        for (int i = 5; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
