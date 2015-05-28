package org.itakeunconf.legacyTicTacToe;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

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

    @Before
    public void setUp() throws Exception {
        tic = new Tic(inputService, tirageFactory);
    }

    @Test
    public void test_one() throws IOException {
        beginWithPlayerA();
        makeMoves(1, 2, 3, 4, 5, 6, 7, 8, 9);
        tic.eval();
        assertThat(getGameResult()).isEqualTo(STUPID_INVISIBLE_CHARACTER_AT_BEGINNING_OF_STRING + "xoxoxoxox");
    }

    @Test
    public void test_two() throws IOException {
        beginWithPlayerB();
        makeMoves(1, 2, 3, 4, 5, 6, 7, 8, 9);
        tic.eval();
        assertThat(getGameResult()).isEqualTo(STUPID_INVISIBLE_CHARACTER_AT_BEGINNING_OF_STRING + "oxoxoxoxo");
    }


    private String getGameResult() {
        return String.valueOf(tic.tab);
    }

    private void makeMoves(Integer firstMove, Integer... moves) {
        when(inputService.nextInt()).thenReturn(firstMove, moves);
    }

    private void beginWithPlayerA() {
        when(tirageFactory.getTirage()).thenReturn(0.1f);
    }

    private void beginWithPlayerB() {
        when(tirageFactory.getTirage()).thenReturn(0.9f);
    }
}