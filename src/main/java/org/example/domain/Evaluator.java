package org.example.domain;

import java.util.List;
import java.util.Stack;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

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
        try {
            return switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> {
                    if (b == 0) {
                        throw new ArithmeticException("0으로 나눌 수 없음");
                    }
                    yield a / b;
                }
                default -> throw new IllegalArgumentException("잘못된 연산자");
            };
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("잘못된 수식");
        }
    }

    private boolean isNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }
}
