package com.calculator.view;

import java.util.Scanner;

public class InputLine {
    public final Scanner scanner = new Scanner(System.in);

    public String readString() {
        return scanner.nextLine();
    }
}
