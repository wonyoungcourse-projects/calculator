package org.example.config;

import org.example.presentation.CalculatorController;
import org.example.view.InputView;
import org.example.view.OutputView;
// config 역할: 자바 클래스 파일을 설정 파일로 지정하는 역할
public class AppConfig {

    private final OutputView outputView =  new OutputView();
    private final InputView inputView =  new InputView();

    private final CalculatorController controller = new CalculatorController(inputView, outputView);

    public CalculatorController getCalculatorController() {
        return controller;
    }
}
