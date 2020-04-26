package com.sukiwaka;

public class StringSample {
    public static void main(String[] args) {
        addString();
        System.out.println();
        searchString();
    }

    private static void addString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("Java");
        }
        String s = sb.toString();
        System.out.println(s);
    }

    private static void searchString() {
        String s1 = "Java and JavaScript";
        if (s1.contains("Java")) {
            System.out.println("文字列s1は、Javaを含んでいます");
        }
        if (s1.endsWith("Java")) {
            System.out.println("文字列s1は、Javaが末尾にあります");
        }
        System.out.println("文字列s1で最初にJavaが登場する位置は" + s1.indexOf("Java"));
        System.out.println(("文字列s1で最後にJavaが登場する位置は" + s1.lastIndexOf("Java")));
    }
}
