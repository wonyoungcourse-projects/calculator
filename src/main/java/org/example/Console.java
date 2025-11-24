package org.example;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    private Console() {}

    public static String readLine() {
        try {
            return getInstance().nextLine();
        } catch (NoSuchElementException e) {
            // 테스트에서 입력이 없을 때 빈 문자열을 반환해야 함
            return "";
        }
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    private static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
