package org.example.domain;

import java.util.List;

public class Expression {

    private final String raw;

    public Expression(String raw) {
        this.raw = raw;
    }

    public int evaluate() {
        Tokenizer tokenizer = new Tokenizer(raw);
        List<String> tokens = tokenizer.tokenize();

        PostfixConverter converter = new PostfixConverter();
        List<String> postfix = converter.toPostfix(tokens);

        Evaluator evaluator = new Evaluator();
        return evaluator.evaluate(postfix);
    }
}
