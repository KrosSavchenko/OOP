package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Class for tests.
 */
class FindTest {
    @Test
    public void largeFile() {
        ArrayList<Integer> first = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            first.add(i * 6);
        }
        Assertions.assertEquals(Main.find("denis10000.txt", "d"), first);
        Assertions.assertEquals(Main.find("denis10000.txt", "de"), first);
        Assertions.assertEquals(Main.find("denis10000.txt", "den"), first);
        Assertions.assertEquals(Main.find("denis10000.txt", "deni"), first);
        Assertions.assertEquals(Main.find("denis10000.txt", "denis"), first);
        first.remove(9999);
        Assertions.assertEquals(Main.find("denis10000.txt", "denis "), first);
    }
    @Test
    public void smallFile() {
        ArrayList<Integer> first = new ArrayList<>(1);
        first.add(8);
        Assertions.assertEquals(Main.find("123.txt", "123"), first);

        ArrayList<Integer> second = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            second.add(i * 2);
        }
        Assertions.assertEquals(Main.find("123.txt", "12"), second);

        ArrayList<Integer> third = new ArrayList<>(5);
        for (int i = 10; i < 15; i++) {
            third.add(i);
        }
        Assertions.assertEquals(Main.find("123.txt", "3"), third);

        ArrayList<Integer> fourth = new ArrayList<>(1);
        fourth.add(-1);
        Assertions.assertEquals(Main.find("123.txt", "321"), fourth);
    }
}