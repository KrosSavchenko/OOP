package ru.nsu.savchenko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest1 {

    @Test
    void plus() {
        Polynomial p2 = new Polynomial(new int[] {1, 1, 1, 0, 0});
        Assertions.assertEquals(p2.toString(), "0");
    }

    @Test
    void minus() {
    }

    @Test
    void times() {
    }

    @Test
    void evaluate() {
    }

    @Test
    void differentiate() {
    }

    @Test
    void testEquals() {
    }
}