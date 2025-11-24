package org.example.presentation;

import org.example.domain.Expression;
import org.example.view.InputView;
import org.example.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {

        String input = inputView.readLine();

        if (input == null || input.isBlank()) {
            outputView.printRaw("");
            return;
        }

        // 허용되지 않은 문자 → 즉시 throw → 테스트 통과
        validateCharacters(input);

        try {
            Expression expression = new Expression(input);
            int result = expression.evaluate();

            outputView.printRaw(String.valueOf(result));
        } catch (IllegalArgumentException e) {
            // 문법 오류만 여기서 처리
            outputView.printRaw("Error: 잘못된 입력입니다.");
        }
    }

    private void validateCharacters(String input) {
        if (!input.matches("[0-9+\\-*/() ]+")) {
            throw new IllegalArgumentException("Invalid character");
        }
    }
}
