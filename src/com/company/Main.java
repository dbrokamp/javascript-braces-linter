package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Linter linter = new Linter();
        Scanner scanner = new Scanner(System.in);

        String statementOfJavaScript = scanner.nextLine();
        linter.linter(statementOfJavaScript);

//      String testCodePass = "(var x = {y: [1, 2, 3]})";
//      String testCodeFail = "(var x = {y: [1, 2, 3]";


    }
}
