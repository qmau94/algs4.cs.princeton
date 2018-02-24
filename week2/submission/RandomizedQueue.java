import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] q;
    private int size;
    
    // construct an empty randomized queue
    public RandomizedQueue() {
        q = (Item[]) new Object[2];
        size = 0;
    }
    
    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }
    
    // return the number of items on the randomized queue
    public int size() {
        return size;
    }
    
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = q[i];
        }
        q = temp;
    }
    
    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("null item");
        if (size > q.length - 1)
            resize(q.length * 2);
        q[size++] = item;
    }
    
    // remove and return a random item
    public Item dequeue() {
        if (size == 0)
            throw new NoSuchElementException("empty queue");
        int i = randomIndex();
        Item item = q[i];
        q[i] = q[size - 1];
        q[size - 1] = null;
        size--;
        if (size > 0 && size < q.length / 4)
            resize(q.length / 2);
        return item;
    }
    
    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0)
            throw new NoSuchElementException("empty queue");
        int i = randomIndex();
        return q[i];
    }
    
    private int randomIndex() {
        return StdRandom.uniform(0, size);
    }
    
    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomListIterator();
    }
    
    private class RandomListIterator implements Iterator<Item> {
        private int i = 0;
        
        @Override
        public boolean hasNext() {
            return i < size;
        }
        
        public void remove() {
            throw new UnsupportedOperationException("no supported");
        }
        
        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("no more objects");
            return q[i++];
        }
        
    }
    
}
