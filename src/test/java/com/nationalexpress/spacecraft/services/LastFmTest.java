package com.nationalexpress.spacecraft.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LastFmTest {
    @Test
    @DisplayName("Entertainment Test with LastFm")
    public void testLastFm () {
        LastFm lastFm = mock(LastFm.class);
        when(lastFm.providers()).thenReturn("LastFm");
        Assertions.assertEquals("LastFm", lastFm.providers());
    }
}
