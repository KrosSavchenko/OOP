package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class for tests.
 */
class TreeTest {
    @Test
    public void test1() {

        Tree<String> tree = new Tree<>("R1");
        Tree<String> a = tree.addChild("A");
        Tree<String> b = a.addChild("B");
        Tree<String> sub = new Tree<>("R2");
        Tree<String> c = sub.addChild("C");
        Tree<String> d = sub.addChild("D");
        Tree<String> R2 = tree.addChild(sub);
        a.remove();
        Assertions.assertFalse(R2.equals(tree));
        Assertions.assertFalse(tree.equals(R2));
        Assertions.assertTrue(tree.equals(tree));
        Assertions.assertTrue(R2.equals(sub));
        Assertions.assertTrue(sub.equals(R2));
    }

}