package org.example.domain;

import java.util.regex.Pattern;

public class Delimiter {

    private final Pattern pattern;

    public Delimiter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public Pattern getPattern() {
        return pattern;
    }
}

