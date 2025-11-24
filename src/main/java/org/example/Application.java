package org.example;

import org.example.config.AppConfig;
import org.example.presentation.CalculatorController;

public class Application {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        CalculatorController controller = config.getCalculatorController();
        controller.start();
    }
}
