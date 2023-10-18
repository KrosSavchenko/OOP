package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Stack;

/**
 * Class of trees.
 *
 * @param <T> Type of value of vertex.
 */
public class Tree<T> implements Iterable<Tree<T>>  {

    T value;
    ArrayList<Tree<T>> childs;
    Tree<T> parent;
    private boolean iterating;
    private boolean warning;
    int iter; // 0 - BFS, DFS another

    /**
     * Construction of class.
     *
     * @param value Value of vertex
     */
    public Tree(T value) {
        this.value = value;
        childs = new ArrayList<Tree<T>>();
        parent = null;
        iter = 0;
        iterating = false;
        warning = false;
    }

    /**
     * Adds a child to the current node.
     *
     * @param val Child value.
     * @return Node with child.
     */
    Tree<T> addChild(T val) {
        Tree<T> newChild = new Tree<>(val);
        newChild.parent = this;
        childs.add(newChild);
        return newChild;
    }

    /**
     * Adds a subtree to the current node.
     *
     * @param subTree The subtree that is being added.
     * @return Node with subtree.
     */
    Tree<T> addChild(Tree<T> subTree) {
        childs.add(subTree);
        subTree.parent = this;
        return subTree;
    }

    /**
     * Remove current list or subtree.
     */
    void remove() {
        if (parent == null) {
            System.exit(1);
        }
        Tree<T> head = this.getHead();
        if (head.iterating) {
            head.warning = true;
        }
        if (!childs.isEmpty()) {
            for (int i = 0; i < childs.size(); i++) {
                childs.get(i).remove();
            }
        }
        parent.childs.remove(this);
    }

    /**
     * Tests two trees for equality.
     *
     * @param other The tree that is compared with the current one.
     * @return True if the trees are equal, otherwise false.
     */
    boolean equals(Tree<T> other) {
        if (this.iter != other.iter) {
            this.iter = 0;
            other.iter = 0;
        }
        java.util.Iterator<Tree<T>> i1 = this.iterator();
        java.util.Iterator<Tree<T>> i2 = other.iterator();
        while (i1.hasNext() && i2.hasNext()) {
            if (i1.next().value != i2.next().value) {
                return false;
            }
        }
        return i1.hasNext() == i2.hasNext();
    }

    /**
     * Looking for a tree head.
     *
     * @return Head of tree.
     */
    Tree<T> getHead() {
        if (this.parent == null) {
            return this;
        }
        Tree<T> head = this.parent;
        while (head.parent !=  null) {
            head = head.parent;
        }
        return head;
    }

    @Override
    public java.util.Iterator<Tree<T>> iterator() {
        if (iter == 0) {
            return new Iterator_bfs(this);
        } else {
            return new Iterator_dfs(this);
        }
    }

    class Iterator_dfs implements java.util.Iterator<Tree<T>> {
        Stack<Tree<T>> st;

        public Iterator_dfs(Tree<T> start) {
            st = new Stack<>();
            st.push(start);
            Tree<T> head = start.getHead();
            head.iterating = true;
        }

        @Override
        public boolean hasNext() {
            return !st.empty();
        }

        @Override
        public Tree<T> next() {
            Tree<T> cur = st.pop();
            Tree<T> head = cur.getHead();
            if (head.warning) {
                throw new ConcurrentModificationException();
            }
            for (int i = 0; i < cur.childs.size(); i++) {
                Tree<T> child = cur.childs.get(i);
                st.push(child);
            }
            if (st.empty()) {
                head.iterating = false;
            }
            return cur;
        }
    }

    class Iterator_bfs implements java.util.Iterator<Tree<T>> {
        ArrayDeque<Tree<T>> queue;

        public Iterator_bfs(Tree<T> start) {
            queue = new ArrayDeque<>();
            queue.addLast(start);
            Tree<T> head = start.getHead();
            head.iterating = true;
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Tree<T> next() {
            Tree<T> cur = queue.pop();
            Tree<T> head = cur.getHead();
            if (head.warning) {
                throw new ConcurrentModificationException();
            }
            for (int i = 0; i < cur.childs.size(); i++) {
                queue.addLast(cur.childs.get(i));
            }
            if (queue.isEmpty()) {
                head.iterating = false;
            }
            return cur;
        }
    }
}

