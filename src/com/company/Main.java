package com.company;

public class Main {

    public static void main(String[] args) {

        Linter linter = new Linter();

        String testCodePass = "(var x = {y: [1, 2, 3]})";
        String testCodeFail = "(var x = {y: [1, 2, 3]";

        linter.linter(testCodePass);
        linter.linter(testCodeFail);

    }
}
