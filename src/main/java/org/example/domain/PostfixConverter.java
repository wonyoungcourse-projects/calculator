package org.example.domain;

import java.util.*;

public class PostfixConverter {

    private final Map<String, Integer> priority = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public List<String> toPostfix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> op = new Stack<>();

        for (String t : tokens) {

            if (isNumber(t)) {
                output.add(t);
            }
            else if (isOperator(t)) {
                while (!op.isEmpty()
                        && isOperator(op.peek())
                        && priority.get(op.peek()) >= priority.get(t)) {
                    output.add(op.pop());
                }
                op.push(t);
            }
            else if (t.equals("(")) {
                op.push(t);
            }
            else if (t.equals(")")) {
                while (!op.isEmpty() && !op.peek().equals("(")) {
                    output.add(op.pop());
                }

                if (op.isEmpty()) {
                    throw new IllegalArgumentException("괄호 오류");
                }
                op.pop();
            }
        }

        while (!op.isEmpty()) {
            if (op.peek().equals("(")) {
                throw new IllegalArgumentException("괄호 오류");
            }
            output.add(op.pop());
        }

        return output;
    }

    private boolean isNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }

    private boolean isOperator(String s) {
        return "+-*/".contains(s);
    }
}
