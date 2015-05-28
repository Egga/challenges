package org.itakeunconf.legacyTicTacToe;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicTest {

    @Test
    public void itName() throws IOException {
        UserInputService inputService = mock(UserInputService.class);
        Tic tic = new Tic(inputService);
        when(inputService.nextInt()).thenReturn(1, 2, 3, 4, 5);
        tic.eval();
        assertThat(String.valueOf(tic.tab)).isEqualTo("o");
    }
}