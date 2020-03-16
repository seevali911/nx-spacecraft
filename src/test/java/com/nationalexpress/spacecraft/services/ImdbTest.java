package com.nationalexpress.spacecraft.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImdbTest {
    @Test
    @DisplayName("Entertainment test with Imdb")
    public void testImdb () {
        Imdb imdb = mock(Imdb.class);
        when(imdb.providers()).thenReturn("Imdb");
        Assertions.assertEquals("Imdb", imdb.providers());

    }
}
