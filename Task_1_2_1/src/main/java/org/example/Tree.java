package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class Tree<T> implements Iterable<Tree<T>>  {
    public static void main(String[] args) {
        Tree<String> tree = new Tree<>("R1");
        Tree<String> a = tree.addChild("A");
        Tree<String> b = a.addChild("B");
        Tree<String> sub = new Tree<>("R2");
        sub.addChild("C");
        sub.addChild("D");
        tree.addChild(sub);
        for (Tree<String> stringTree : tree) {
            System.out.println(stringTree.value);
        }

    }
    T value;
    ArrayList<Tree<T>> childs;
    Tree<T> parent;

    public Tree(T value) {
        this.value = value;
        childs = new ArrayList<Tree<T>>();
        parent = null;
    }

    Tree<T> addChild(T val) {
        Tree<T> newChild = new Tree<>(val);
        newChild.parent = this;
        childs.add(newChild);
        return newChild;
    }

    Tree<T> addChild(Tree<T> subTree) {
        childs.add(subTree);
        subTree.parent = this;
        return subTree;
    }

    void remove() {
        if (parent == null) {
            System.exit(100);
        }
        if (!childs.isEmpty()) {
            for (int i = 0; i < childs.size(); i++) {
                childs.get(i).remove();
            }
        }
        parent.childs.remove(this);
    }

    /*public class CollectionDFS implements Iterable<Tree<T>> {
        Tree<T> head;

        public CollectionDFS(Tree<T> head) {
            this.head = head;
        }

        @Override
        public IteratorDFS iterator() {
            return new IteratorDFS(head);
        }
    }*/
    @Override
    public IteratorDFS iterator() {
        return new IteratorDFS(this);
    }

    class IteratorDFS implements java.util.Iterator<Tree<T>> {
        Stack<Tree<T>> st;

        public IteratorDFS(Tree<T> head) {
            st = new Stack<>();
            st.push(head);
        }

        @Override
        public boolean hasNext() {
            return !st.empty();
        }

        @Override
        public Tree<T> next() {
            Tree<T> cur = st.pop();
            for (int i = 0; i < cur.childs.size(); i++) {
                Tree<T> child = cur.childs.get(i);
                st.push(child);
            }
            return cur;
        }
    }

    class IteratorBFS implements java.util.Iterator<Tree<T>> {
        ArrayDeque<Tree<T>> queue;

        public IteratorBFS(Tree<T> head) {
            queue = new ArrayDeque<>();
            queue.addLast(head);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Tree<T> next() {
            Tree<T> cur = queue.pop();
            for (int i = 0; i < cur.childs.size(); i++) {
                queue.addLast(cur.childs.get(i));
            }
            return cur;
        }
    }
}

