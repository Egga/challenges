package org.itakeunconf.legacyTicTacToe;

import java.util.Scanner;

public class UserInputService {
    Scanner scanner;

    public UserInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    int nextInt() {
        return getScanner().nextInt();
    }

    void nextLine() {
        getScanner().nextLine();
    }
}