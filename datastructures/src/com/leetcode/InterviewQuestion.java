package com.leetcode;

//virtusa interview question
public class InterviewQuestion {

    public static void main(String[] args) {
        String s1 = "Harinadh";
        String s2 = "12345678910";

        char[] ch = new char[s1.length() + s2.length()];

        soltion1(s1, s2);
    }

    private static void soltion1(String s1, String s2) {

        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            System.out.print(s1.charAt(i++) + "" + s2.charAt(j++) + " ");
        }
        while (i < s1.length()) {
            System.out.print(s1.charAt(i++) + " ");
        }
        while (j < s2.length()) {
            System.out.print(s2.charAt(j++) + " ");
        }

    }
}
