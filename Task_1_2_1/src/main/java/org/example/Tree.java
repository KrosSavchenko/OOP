package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class Tree<T> {
    T value;
    ArrayList<Tree<T>> childs;

    public Tree(T value) {
        this.value = value;
    }

    Tree<T> addChild(T val) {
        Tree<T> newChild = new Tree<T>(val);
        childs.add(newChild);
        return newChild;
    }
}

