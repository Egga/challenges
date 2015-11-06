package org.itakeunconf.legacyTicTacToe;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TicTest {

    public static final String STUPID_INVISIBLE_CHARACTER_AT_BEGINNING_OF_STRING = "\u0000";

    @Mock
    UserInputService inputService;

    @Mock
    TirageFactory tirageFactory;


    Tic tic;

    @Test
    public void itName() {
        ICombinatoricsVector<Integer> originalVector = Factory.createVector(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        Generator<Integer> gen = Factory.createSimpleCombinationGenerator(originalVector, 5);

        long numberOfGeneratedObjects = gen.getNumberOfGeneratedObjects();
        System.out.println(numberOfGeneratedObjects);

        Float[] floats = {0.1f, 0.9f};
        for (Float tirage : floats) {
            beginWithPlayerA(tirage);
            for (ICombinatoricsVector<Integer> perm : gen) {
                tic = new Tic(inputService, tirageFactory);
                List<Integer> vector = perm.getVector();

                List<Integer> otherPlayersMoves = new ArrayList<Integer>();
                for (int i = 1; i < 10; i++) {
                    if (!vector.contains(i)) {
                        otherPlayersMoves.add(i);
                    }
                }

                Integer first = vector.remove(0);
                makeMoves(first, vector.toArray(new Integer[vector.size()]));
            }
        }
    }

    private void assertGameResultEquals(String expected) {
        assertThat(getGameResult()).isEqualTo(STUPID_INVISIBLE_CHARACTER_AT_BEGINNING_OF_STRING + expected);
    }

    private String getGameResult() {
        return String.valueOf(tic.tab);
    }

    private void makeMoves(Integer firstMove, Integer... moves) {
        when(inputService.nextInt()).thenReturn(firstMove, moves);
    }

    private void beginWithPlayerA(Float value) {
        when(tirageFactory.getTirage()).thenReturn(value);
    }

}