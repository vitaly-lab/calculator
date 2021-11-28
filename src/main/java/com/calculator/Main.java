package com.calculator;

import com.calculator.controller.Controller;
import com.calculator.model.Model;
import com.calculator.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model, view);
        controller.run();
    }
}
