package org.example.domain;

import java.util.List;
import java.util.Stack;

public class Evaluator {

    public int evaluate(List<String> postfix) {

        Stack<Integer> st = new Stack<>();

        for (String t : postfix) {

            if (isNumber(t)) {
                st.push(Integer.parseInt(t));
            } else {
                if (st.size() < 2) {
                    throw new IllegalArgumentException("잘못된 수식");
                }

                int b = st.pop();
                int a = st.pop();
                st.push(calc(a, b, t));
            }
        }

        if (st.size() != 1) {
            throw new IllegalArgumentException("잘못된 수식");
        }

        return st.pop();
    }

    private int calc(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("잘못된 연산자");
        };
    }

    private boolean isNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }
}
