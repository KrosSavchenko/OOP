package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class for tests.
 */
class TreeTest {
    @Test
    public void testBFS() {
        Tree<String> tree = new Tree<>("R1");
        Tree<String> a = tree.addChild("A");
        Tree<String> b = a.addChild("B");
        Tree<String> sub = new Tree<>("R2");
        Tree<String> c = sub.addChild("C");
        Tree<String> d = sub.addChild("D");
        Tree<String> r2 = tree.addChild(sub);
        a.remove();
        Assertions.assertFalse(r2.equals(tree));
        Assertions.assertFalse(tree.equals(r2));
        Assertions.assertTrue(tree.equals(tree));
        Assertions.assertTrue(r2.equals(sub));
        Assertions.assertTrue(sub.equals(r2));
    }

    @Test
    public void testDFS() {
        Tree<Integer> t1 = new Tree<>(1);
        t1.addChild(2);
        Tree<Integer> t3 = t1.addChild(3);
        Tree<Integer> t4 = t1.addChild(4);
        Tree<Integer> t11 = t1;
        Tree<Integer> t5 = new Tree<>(5);
        Tree<Integer> t6 = t5.addChild(6);
        Tree<Integer> t7 = t6.addChild(7);
        Tree<Integer> t8 = t3.addChild(8);
        Tree<Integer> tmp = t4.addChild(t5);
        tmp.iter = 1;
        t5.iter = 1;
        t11.iter = 1;
        t1.iter = 1;
        Assertions.assertTrue(tmp.equals(t5));
        Assertions.assertTrue(t5.equals(tmp));
        Assertions.assertFalse(t1.equals(t11));
        Assertions.assertFalse(t11.equals(t1));
    }


}