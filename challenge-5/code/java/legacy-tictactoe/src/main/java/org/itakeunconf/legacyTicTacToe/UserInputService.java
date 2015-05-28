package org.itakeunconf.legacyTicTacToe;

import java.util.Scanner;

public class UserInputService {
    Scanner scanner;

    public UserInputService() {
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

    public void setScanner(Scanner scanner, Tic tic) {
        this.scanner = scanner;
    }
}