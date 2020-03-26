/* *****************************************************************************
 *  Name: Sayar Banerjee
 *  Date: 25/03/2020
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int N;

    // construct an empty randomized queue
    public RandomizedQueue() {
        arr = (Item[]) new Object[1];
        N = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return N;
    }

    private void resize(int capacity) {
        assert capacity >= N;

        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = arr[i];

        }
        arr = copy;

    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Please enter non-null items.");
        if (N == arr.length) resize(2 * arr.length);
        arr[N++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
        int index = StdRandom.uniform(N);
        Item popitem = arr[index];
        arr[index] = arr[N - 1];
        arr[N - 1] = null;
        N--;
        if (N > 0 && N == arr.length / 4) resize(arr.length / 2);
        return popitem;

    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
        return arr[StdRandom.uniform(N)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        private int maxindex;
        private Item[] randomindices;


        private RandomIterator() {
            randomindices = (Item[]) new Object[N];
            for (int i = 0; i < N; i++) {
                randomindices[i] = arr[i];
            }
            maxindex = N;
        }

        public boolean hasNext() {
            return maxindex > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException("No such operation.");
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int i = StdRandom.uniform(maxindex);
            Item res = randomindices[i];
            randomindices[i] = randomindices[maxindex - 1];
            randomindices[maxindex - 1] = null;
            maxindex--;
            return res;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);
        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }


    }
}
