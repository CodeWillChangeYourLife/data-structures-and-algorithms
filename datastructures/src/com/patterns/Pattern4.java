package com.patterns;

/*56789
  5678
  567
  56
  5 */
public class Pattern4 {

    public static void main(String[] args) {
        for (int i = 5; i > 0; i--) {
            int no = 5;
            for (int j = 1; j <= i; j++) {
                System.out.print(no + " ");
                no++;
            }
            System.out.println();
        }
    }
}
