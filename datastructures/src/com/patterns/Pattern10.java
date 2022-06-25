package com.patterns;

/*      *
 ***
 *****
 *******
 *********
 ***********
 *************
 ****************/
public class Pattern10 {

    public static void main(String[] args) {
        int no = 1;
        for (int i = 0; i < 9; i++) {
            int j = i;
            while (j < no) {
                System.out.print("*" + " ");
                j++;
            }
            System.out.println();
            no = no+ 2;
        }
    }

}
