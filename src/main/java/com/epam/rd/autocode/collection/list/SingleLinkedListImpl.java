package com.epam.rd.autocode.collection.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class SingleLinkedListImpl implements List {
    private static Node head = null;


    public SingleLinkedListImpl() {
        head = new Node(0, null);
        Size.size = 0;
    }

    @Override
    public void clear() {
        head.next = null;
        Size.size = 0;
    }

    @Override
    public int size() {
        return Size.size;
    }


    /**
     * Inserts the specified element at the <b>front</b> of this list
     *
     * @param el the element to add
     * @return {@code true} if this list was changed {@code false} otherwise
     */
    @Override
    public boolean add(Object el) {
        if (el == null) {
            throw new NullPointerException();
        }
        head.next = new Node(el, head.next);
        Size.size++;

        return true;
    }

    @Override
    public Optional<Object> remove(Object el) {
        if (el == null) {
            throw new NullPointerException();
        }

        Node current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.data, el)) {
                Node removedNode = current.next;
                current.next = current.next.next;
                Size.size--;
                return Optional.of(removedNode.data);
            }
            current = current.next;
        }

        return Optional.empty();
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
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
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head.next;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
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

        return new Iterator<>() {
            boolean isCalled = true;
            private Node current = head;
            private Node previous;

            @Override
            public boolean hasNext() {
                return current.next != null;

            }

            @Override
            public Object next() {
                if (! hasNext()) {
                    throw new NoSuchElementException();
                }
                previous = current;
                current = current.next;
                isCalled = false;
                return current.data;
            }

            @Override
            public void remove() {
                if (current == null || isCalled) {
                    throw new IllegalStateException();
                }

                previous.next = current.next;
                current = previous;
                Size.size--;
                isCalled = true;
            }
        };
    }

    public static class Node {
        Object data;
        Node next;

        Node(Object data, Node next) {
            this.data = data;
            this.next = next;

        }

        @Override
        public String toString() {
            return "[" + data + ']';
        }

    }

    static class Size {
        public static int size;
    }

}

