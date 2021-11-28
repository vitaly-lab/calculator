package com.calculator.controller;

import com.calculator.model.Model;
import com.calculator.view.InputLine;
import com.calculator.view.View;

import static com.calculator.view.Constants.Constans.MAIN_MENU;
import static com.calculator.view.Constants.Constans.MESSAGE;


public class Controller {
    private static final String RESULT_COMMAND = "=";
    private static final String EXIT_COMMAND = "q";

    private final Model model;
    private final View view;
    private final InputLine inputLine = new InputLine();

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        showMainMenu();
        inputConsole();
    }

    private void inputConsole() {
        String[] symbol = new String[3];

        while (true) {
            String input = inputLine.readString();
            if (input.equals(RESULT_COMMAND)) {
                break;
            }
            if (input.equals(EXIT_COMMAND)) {
                return;
            }
            symbol = input.split(" ");
        }
        int oneSymbol = Integer.parseInt(symbol[0]);
        String twoSymbol = symbol[1];
        int threeSymbol = Integer.parseInt(symbol[2]);

        setFunction(oneSymbol, twoSymbol, threeSymbol);

        showMessage();
        inputConsole();
    }

    private void setFunction(int oneOperand, String operator, int twoOperand) {

        switch (operator) {
            case "+":
                showResult(model.sum(oneOperand, twoOperand));
                break;
            case "-":
                showResult(model.subtraction(oneOperand, twoOperand));
                break;
            case "*":
                showResult(model.multiplication(oneOperand, twoOperand));
                break;
            case "/":
                showResult(model.division(oneOperand, twoOperand));
                break;
        }
    }

    private void showResult(double result) {
        view.printMessage(String.valueOf(result));
    }

    private void showMainMenu() {
        view.printMessage(MAIN_MENU);
    }

    private void showMessage() {
        view.printMessage(MESSAGE);
    }
}
