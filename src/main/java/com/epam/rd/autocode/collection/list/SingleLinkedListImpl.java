package com.epam.rd.autocode.collection.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class SingleLinkedListImpl implements List {

    private Node head;

    private static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }

        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + data + ']';
        }
    }

    public SingleLinkedListImpl() {
        head = new Node(0, null);
    }

    @Override
    public void clear() {
       // place tour code here
    }

    @Override
    public int size() {
        // place tour code here
        return 0;
    }

    /**
     * Inserts the specified element at the <b>front</b> of this list
     *
     * @param el the element to add
     * @return {@code true} if this list was changed {@code false} otherwise
     */
    @Override
    public boolean add(Object el) {
        // place tour code here
        return true;
    }

    @Override
    public Optional<Object> remove(Object el) {
        // place tour code here
        return null;
    }

    @Override
    public Object get(int index) {
        // place tour code here
        return null;
    }

    /**
     * Makes a string representation of this list.
     * The elements ordering must be coordinated with the
     * {@code Iterator} of this list.
     *
     * @return a string representation of this list.
     */
    @Override
    public String toString() {
        // place tour code here
        return null;
    }

    /**
     * Returns an iterator over elements.
     * Iterator must implement the remove method.
     * <pre>
     * list.add("A");
     * list.add("B");
     * list.add("C");
     * for(Object obj : list) { System.out.print(obj) } // prints: CBA
     * </pre>
     *
     * @return an iterator
     */
    @Override
    public Iterator<Object> iterator() {
        // place tour code here
        return null;
    }
}
