package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class for tests.
 */
class TreeTest {
    @Test
    public void testEquals() {
        Tree<Integer> tree = new Tree<>(10);
        tree.addChild(22);
        Tree<Integer> list = tree.addChild(23);
        list.addChild(31);
        list.addChild(32);
        Tree<Integer> tree1 = new Tree<>(10);
        tree1.addChild(22);
        Tree<Integer> list1 = tree1.addChild(23);
        list1.addChild(31);
        Tree<Integer> tmp = list1.addChild(32);
        Assertions.assertEquals(tree1, tree);
        tmp.remove();
        Assertions.assertNotEquals(tree, tree1);
        list1.addChild(33);
        tree.fs = Tree.TypeFirstSearch.DFS;
        tree1.fs = Tree.TypeFirstSearch.DFS;
        Assertions.assertNotEquals(tree, tree1);
    }

    @Test
    public void testBfs() {
        Tree<String> tree = new Tree<>("R1");
        Tree<String> a = tree.addChild("A");
        Tree<String> b = a.addChild("B");
        Tree<String> sub = new Tree<>("R2");
        Tree<String> c = sub.addChild("C");
        Tree<String> d = sub.addChild("D");
        Tree<String> r2 = tree.addChild(sub);
        a.remove();
        Assertions.assertNotEquals(r2, tree);
        Assertions.assertNotEquals(tree, r2);
        Assertions.assertEquals(tree, tree);
        Assertions.assertEquals(r2, sub);
        Assertions.assertEquals(sub, r2);
    }

    @Test
    public void testDfs() {
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
        tmp.fs = Tree.TypeFirstSearch.DFS;
        t5.fs = Tree.TypeFirstSearch.DFS;
        t11.fs = Tree.TypeFirstSearch.DFS;
        t1.fs = Tree.TypeFirstSearch.BFS;
        Assertions.assertEquals(tmp, t5);
        Assertions.assertEquals(t5, tmp);
        Assertions.assertEquals(t1, t11);
        Assertions.assertEquals(t11, t1);
        Assertions.assertEquals(t11, t1);
        Tree<Integer> tt5 = new Tree<>(5);
        Tree<Integer> tt6 = tt5.addChild(6);
        Tree<Integer> tt7 = tt6.addChild(7);
        tt5.fs = Tree.TypeFirstSearch.DFS;
        Assertions.assertEquals(tt5, t5);
        tt7.addChild(7);
        Assertions.assertNotEquals(t5, tt5);
        Assertions.assertNotEquals(tt5, t5);

    }
}