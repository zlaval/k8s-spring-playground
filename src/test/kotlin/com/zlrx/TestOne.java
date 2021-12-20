package com.zlrx;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOne {

    @Test
    @DisplayName("Should return true")
    public void firstTest() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Should return false")
    public void secondTest() {
        assertTrue(false);
    }
}
