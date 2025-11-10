package org.example;

import org.example.testutil.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationTest extends NsTest {
    @DisplayName("calculateNumber 메서드는 숫자 계산을 성공해야 한다.")
    @Test
    public void calculateNumberMustBeSuccess() {
        // Provide a line of space-separated numbers
        run("1+2");
        assertEquals("3", output());
    }

    @DisplayName("빈 입력은 빈 문자열을 출력해야 한다.")
    @Test
    public void emptyInputShouldPrintEmptyLine() {
        run("");
        assertEquals("", output());
    }

    @DisplayName("잘못된 입력은 에러 메시지를 출력해야 한다.")
    @Test
    public void invalidInputShouldPrintErrorMessage() {
        run("1++2");
        assertEquals("Error: 잘못된 입력입니다.", output());
    }

    @DisplayName("잘못된 연산자는 IllegalArgumentException 예외를 던져야 한다.")
    @Test
    public void invalidOperatorShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> run("1$2"));
    }

    @DisplayName("연산자 계산은 우선순위를 따라야 한다. 1")
    @Test
    public void operatorCalculationShouldFollowPrecedence1() {
        run("2+3*4");
        assertEquals("14", output());
    }

    @DisplayName("연산자 계산은 우선순위를 따라야 한다. 2")
    @Test
    public void operatorCalculationShouldFollowPrecedence2() {
        run("(2+3)*4");
        assertEquals("20", output());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
