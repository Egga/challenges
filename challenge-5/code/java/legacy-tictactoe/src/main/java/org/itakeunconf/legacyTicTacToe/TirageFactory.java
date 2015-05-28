package org.itakeunconf.legacyTicTacToe;

import java.util.Date;
import java.util.Random;

/**
 * @author egga
 */
public class TirageFactory {
    float getTirage() {
        float tirage = 0;
        Random random = new Random(new Date().getTime());
        random.nextFloat();
        tirage = random.nextFloat();
        return tirage;
    }
}
