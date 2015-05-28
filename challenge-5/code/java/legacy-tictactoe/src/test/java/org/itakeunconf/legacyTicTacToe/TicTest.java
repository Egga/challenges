package org.itakeunconf.legacyTicTacToe;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicTest {

    public static final String STUPID_INVISIBLE_CHARACTER_AT_BEGINNING_OF_STRING = "\u0000";

    @Test
    public void itName() throws IOException {
        UserInputService inputService = mock(UserInputService.class);
        TirageFactory tirageFactory = mock(TirageFactory.class);
        Tic tic = new Tic(inputService, tirageFactory);
        when(inputService.nextInt()).thenReturn(1, 2, 3, 4, 5, 6, 7, 8, 9);
        when(tirageFactory.getTirage()).thenReturn(0.1f);
        tic.eval();
        String actual = String.valueOf (tic.tab);
        assertThat(actual).isEqualTo(STUPID_INVISIBLE_CHARACTER_AT_BEGINNING_OF_STRING + "xoxoxoxox");
    }
}