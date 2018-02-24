package algs4.week2.permutation;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;

    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
        size = 0;
        head = null;
        tail = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        checkArgument(item);
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        if (isEmpty()) {
            tail = head;
        } else {
            oldHead.prev = head;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        checkArgument(item);
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.prev = oldTail;
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        size++;
    }

    private void checkArgument(Item item) {
        if (item == null)
            throw new IllegalArgumentException("null arguments");
    }

    // remove and return the item from the front
    public Item removeFirst() {
        checkEmptyDeque();
        Node oldHead = head;
        if (size() > 1) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return oldHead.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        checkEmptyDeque();
        Node oldTail = tail;
        if (size() > 1) {
            tail = oldTail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return oldTail.item;
    }

    private void checkEmptyDeque() {
        if (isEmpty())
            throw new NoSuchElementException("empty deque");
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator<Item>();
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("no supported");
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("no more item");
            }
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }

    }

}
