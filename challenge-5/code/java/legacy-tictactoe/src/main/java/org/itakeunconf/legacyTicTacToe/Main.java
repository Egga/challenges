package org.itakeunconf.legacyTicTacToe;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tic tic = new Tic(new UserInputService(new Scanner(System.in)));
        try {
            tic.eval();
            for (int i = 1; i <= 9; i++) {
                System.out.print(tic.tab[i]);
                if (i == 3 || i == 6 || i == 9)
                    System.out.print("\n");
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
