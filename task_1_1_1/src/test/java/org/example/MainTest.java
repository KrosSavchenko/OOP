package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    void checkMain() {
        Main.main(new String[] {});
        assertTrue(true);
    }

    @Test
    void doINeedToCheckDefaultConstructor() {
        final var sampleInstance = new Main();
    }
}
