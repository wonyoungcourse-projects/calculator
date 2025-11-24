package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private final String exp;

    public Tokenizer(String exp) {
        this.exp = exp.replace(" ", "");
    }

    public List<String> tokenize() {
        List<String> tokens = new ArrayList<>();
        StringBuilder num = new StringBuilder();

        for (char c : exp.toCharArray()) {

            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                if (num.length() > 0) {
                    tokens.add(num.toString());
                    num.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }
        }

        if (num.length() > 0) {
            tokens.add(num.toString());
        }

        return tokens;
    }
}
