package ru.nsu.savchenko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class for tests.
 */
class PolynomialTest {
    @Test
    void toStringTest() {
          Polynomial p2 = new Polynomial(new int[] {1, 1, 1, 0, 0});
          Assertions.assertEquals(p2.toString(), "0");
//        p = new Polynomial(new int[] {1});
//        Assertions.assertEquals(p.toString(), "1");
//        p = new Polynomial(new int[] {4, 0});
//        Assertions.assertEquals(p.toString(), "4");
//        p = new Polynomial(new int[] {0, 5});
//        Assertions.assertEquals(p.toString(), "5x");
//        p = new Polynomial(new int[] {99, 8});
//        Assertions.assertEquals(p.toString(), "8x + 99");
//        p = new Polynomial(new int[] {9, 0, 0, 0});
//        Assertions.assertEquals(p.toString(), "9");
//        p = new Polynomial(new int[] {1, 2, 3});
//        Assertions.assertEquals(p.toString(), "3x^2 + 2x + 1");
//        p = new Polynomial(new int[] {0, 2, 3});
//        Assertions.assertEquals(p.toString(), "3x^2 + 2x");
//        p = new Polynomial(new int[] {1, 0, 3});
//        Assertions.assertEquals(p.toString(), "3x^2 + 1");
//        p = new Polynomial(new int[] {1, 2, 0});
//        Assertions.assertEquals(p.toString(), "2x + 1");
//        p = new Polynomial(new int[] {0, 0, 4});
//        Assertions.assertEquals(p.toString(), "4x^2");
//        p = new Polynomial(new int[] {43, 17, 348, 1, 0, 43, 9, 0, 21});
//        Assertions.assertEquals(p.toString(),
//            "21x^8 + 9x^6 + 43x^5 + 1x^3 + 348x^2 + 17x + 43");
//        p = new Polynomial(new int[] {0, 0, 0});
//        Assertions.assertEquals(p.toString(), "0");
//        p = new Polynomial(new int[] {0});
//        Assertions.assertEquals(p.toString(), "0");
//        p = new Polynomial(new int[] {});
//        Assertions.assertEquals(p.toString(), "");
    }

    @Test
    void equalsTest() {
        Polynomial p1 = new Polynomial(new int[] {1, 2, 3});
        Polynomial p2 = new Polynomial(new int[] {2, 3});
        Assertions.assertFalse(p1.equals(p2));
        Assertions.assertFalse(p2.equals(p1));
        p2 = new Polynomial(new int[] {10, 20, 30});
        Assertions.assertFalse(p1.equals(p2));
        Assertions.assertFalse(p2.equals(p1));
        p1 = new Polynomial(new int[] {0, 0, 0});
        Assertions.assertFalse(p1.equals(p2));
        p2 = new Polynomial();
        Assertions.assertTrue(p2.equals(p2));
        Assertions.assertFalse(p1.equals(p2));
        Assertions.assertFalse(p2.equals(p1));
        p1 = new Polynomial(new int[] {5, 6, 7, 8});
        p2 = new Polynomial(new int[] {5, 6, 7, 8, 9});
        Assertions.assertFalse(p1.equals(p2));
        Assertions.assertFalse(p2.equals(p1));
        p1 = new Polynomial(new int[] {5, 6, 7, 8, 9});
        Assertions.assertTrue(p1.equals(p2));
        Assertions.assertTrue(p2.equals(p1));
        Assertions.assertTrue(p1.equals(p1));
        p1 = new Polynomial(new int[] {0, 0, 0, 0, 0});
        p2 = new Polynomial(new int[] {0});
        Assertions.assertTrue(p1.equals(p2));
    }

    @Test
    void exampleFromTask() {
        Polynomial p1 = new Polynomial(new int[] {4, 3, 6, 7});
        Polynomial p2 = new Polynomial(new int[] {3, 2, 8});
        Assertions.assertEquals(p1.plus(p2.differentiate(1)).toString(),
            "7x^3 + 6x^2 + 19x + 6");
        Assertions.assertEquals(p1.times(p2).evaluate(2), 3510);
    }

    @Test
    void plusTest() {
        Polynomial p1 = new Polynomial(new int[] {1, 2, 3, 4});
        Polynomial p2 = new Polynomial(new int[] {10, 20, 30, 40});
        Assertions.assertEquals(p1.plus(p2).toString(), "44x^3 + 33x^2 + 22x + 11");
        p1 = new Polynomial(new int[] {1});
        Assertions.assertTrue(p1.plus(p2).equals(new Polynomial(new int[] {11, 20, 30, 40})));
        Assertions.assertTrue(p2.plus(p1).equals(new Polynomial(new int[] {11, 20, 30, 40})));
        p2 = new Polynomial(new int[] {0, 0, 0, 0, 0, 3});
        Assertions.assertTrue(p2.plus(p2).equals(new Polynomial(new int[] {0, 0, 0, 0, 0, 6})));
        Polynomial p3 = new Polynomial(new int[] {0});
        Polynomial p4 = new Polynomial(new int[] {4, 23, 43, 92, 8, 43, 550});
        Assertions.assertTrue(p1.plus(p2).plus(p3).plus(p4).equals(
            new Polynomial(new int[] {5, 23, 43, 92, 8, 46, 550})));
        p1 = new Polynomial(new int[] {5, 6, 32, 64, 999, 38, 9, 0, 1});
        p2 = new Polynomial(new int[] {20});
        Assertions.assertTrue(p2.plus(p1).equals(
                new Polynomial(new int[] {25, 6, 32, 64, 999, 38, 9, 0, 1})));
        p2 = new Polynomial();
        Assertions.assertTrue((p1.plus(p2)).equals(p1));
        p2 = new Polynomial(new int[] {0});
        Assertions.assertTrue((p1.plus(p2)).equals(p1));
    }

    @Test
    void minusTest() {
        Polynomial p1 = new Polynomial(new int[] {5, 6, 32, 64, 999, 38, 9, 0, 1});
        Polynomial p2 = new Polynomial(new int[] {4, 5, 2, 4, 5, 7, 10, 43});
        Assertions.assertTrue(p1.minus(p2).equals(
            new Polynomial(new int[] {1, 1, 30, 60, 994, 31, -1, -43, 1})));
        Assertions.assertTrue(p2.minus(p1).equals(
            new Polynomial(new int[] {-1, -1, -30, -60, -994, -31, 1, 43, -1})));
        Assertions.assertTrue(p1.minus(p2).plus(p2).equals(p1));
        p2 = new Polynomial(new int[] {20});
        Assertions.assertTrue(p1.minus(p2).equals(
            new Polynomial(new int[] {-15, 6, 32, 64, 999, 38, 9, 0, 1})));
        Assertions.assertTrue(p2.minus(p1).equals(
            new Polynomial(new int[] {15, -6, -32, -64, -999, -38, -9, 0, -1})));
        p1 = new Polynomial(new int[] {1, 2, 3});
        Assertions.assertTrue(p1.minus(p1).equals(new Polynomial(new int[] {0})));
    }

    @Test
    void timesTest() {
        Polynomial p1 = new Polynomial(new int[] {0, 0, 0, 0, 0});
        Polynomial p2 = new Polynomial(new int[] {0});
        Assertions.assertTrue((p1.times(p2)).equals(p2));
        p1 = new Polynomial(new int[] {0, 0, 0, 0, 2});
        p2 = new Polynomial(new int[] {0, 0, 34});
        Assertions.assertTrue((p1.times(p2)).equals(
            new Polynomial(new int[] {0, 0, 0, 0, 0, 0, 68})));
        p1 = new Polynomial(new int[] {10, 20});
        p2 = new Polynomial(new int[] {1, 2, 3, 4});
        Assertions.assertTrue((p1.times(p2)).equals(
            new Polynomial(new int[] {10, 40, 70, 100, 80})));
        p1 = new Polynomial(new int[] {-5, 2, 8, -3, -3, 0, 1, 0, 1});
        p2 = new Polynomial(new int[] {21, -9, -4, 0, 5, 0, 3});
        Assertions.assertTrue((p1.times(p2)).equals(new Polynomial(
            new int[] {-105, 87, 170, -143, -93, 49, 58, -18, 26, -18, -8, 0, 8, 0, 3})));
    }

    @Test
    void evaluateTest() {
        Polynomial p = new Polynomial(new int[] {0});
        Assertions.assertEquals(p.evaluate(3), 0);
        p = new Polynomial(new int[] {8332, 0, 0, 0, 0});
        Assertions.assertEquals(p.evaluate(2324), 8332);
        p = new Polynomial(new int[] {7, 3, 1, 3, 5, 57, 4, 3});
        Assertions.assertEquals(p.evaluate(5), 478547);
        Assertions.assertEquals(p.evaluate(0), 7);
        Assertions.assertEquals(p.evaluate(6), 1476853);
    }

    @Test
    void differentiateTest() {
        Polynomial p = new Polynomial(new int[] {0});
        Assertions.assertTrue(p.differentiate(0).equals(p.differentiate(5)));
        p = new Polynomial(new int[] {93, 1, 2, 3, 4});
        Assertions.assertTrue(p.differentiate(0).equals(p));
        Assertions.assertTrue(p.differentiate(1).equals(
            new Polynomial(new int[] {1, 4, 9, 16})));
        Assertions.assertTrue(p.differentiate(2).equals(
                new Polynomial(new int[] {4, 18, 48})));
        Assertions.assertTrue(p.differentiate(3).equals(
                new Polynomial(new int[] {18, 96})));
        Assertions.assertTrue(p.differentiate(4).equals(
                new Polynomial(new int[] {96})));
        Assertions.assertTrue(p.differentiate(5).equals(
                new Polynomial(new int[] {0})));
    }
}