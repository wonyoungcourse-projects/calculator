package org.example.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Delimiters {

    private final List<Delimiter> delimiters;

    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;  // 정상
    }

    public String toRegex() {
        return delimiters.stream()
                .map(d -> d.getPattern().pattern())
                .collect(Collectors.joining("|"));
    }
}
