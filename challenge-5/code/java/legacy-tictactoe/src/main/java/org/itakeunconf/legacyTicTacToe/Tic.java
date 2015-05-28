package org.itakeunconf.legacyTicTacToe;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Tic {
    private final UserInputService userInputService = new UserInputService();
    int i, a;
    char[] tab = new char[10];

    public Tic(Scanner scanner) {
        this.setScanner(scanner);
    }

    void choice() throws IOException {
        float tirage = 0;
        Random random = new Random(new Date().getTime());
        random.nextFloat();
        tirage = random.nextFloat();

        if (tirage < 0.5) {
            for (i = 1; i <= 9; i++) {
                if (i % 2 != 0) {
                    System.out.print("player A:");
                    a = userInputService.nextInt();
                    userInputService.getScanner().nextLine();
                    tab[a] = 'x';
                } else {
                    System.out.print("player B:");
                    a = userInputService.nextInt();
                    userInputService.getScanner().nextLine();
                    tab[a] = 'o';
                }
            }
        }

        if (tirage >= 0.5) {
            for (i = 1; i <= 9; i++) {
                if (i % 2 != 0) {
                    System.out.print("player B:");
                    a = userInputService.nextInt();
                    userInputService.getScanner().nextLine();
                    tab[a] = 'o';
                } else {
                    System.out.print("player A:");
                    a = userInputService.nextInt();
                    userInputService.getScanner().nextLine();
                    tab[a] = 'x';
                }
            }
        }
    }

    void eval() throws IOException {
        choice();
        if ((tab[1] == 'x') && (tab[2] == 'x') && (tab[3] == 'x') ||
                (tab[4] == 'x') && (tab[5] == 'x') && (tab[6] == 'x') ||
                (tab[7] == 'x') && (tab[8] == 'x') && (tab[9] == 'x') ||
                (tab[1] == 'x') && (tab[4] == 'x') && (tab[7] == 'x') ||
                (tab[2] == 'x') && (tab[5] == 'x') && (tab[8] == 'x') ||
                (tab[3] == 'x') && (tab[6] == 'x') && (tab[9] == 'x') ||
                (tab[1] == 'x') && (tab[5] == 'x') && (tab[9] == 'x') ||
                (tab[3] == 'x') && (tab[5] == 'x') && (tab[7] == 'x'))

            System.out.println("\nthe winner is : player A\n");

        if ((tab[1] == 'o') && (tab[2] == 'o') && (tab[3] == 'o') ||
                (tab[4] == 'o') && (tab[5] == 'o') && (tab[6] == 'o') ||
                (tab[7] == 'o') && (tab[8] == 'o') && (tab[9] == 'o') ||
                (tab[1] == 'o') && (tab[4] == 'o') && (tab[7] == 'o') ||
                (tab[2] == 'o') && (tab[5] == 'o') && (tab[8] == 'o') ||
                (tab[3] == 'o') && (tab[6] == 'o') && (tab[9] == 'o') ||
                (tab[1] == 'o') && (tab[5] == 'o') && (tab[9] == 'o') ||
                (tab[3] == 'o') && (tab[5] == 'o') && (tab[7] == 'o'))

            System.out.println("\nthe winner is : player B\n");
    }

    public Scanner getScanner() {
        return userInputService.getScanner();
    }

    public void setScanner(Scanner scanner) {
        this.userInputService.scanner = scanner;
    }
}