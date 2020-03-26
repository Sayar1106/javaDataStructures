/* *****************************************************************************
 *  Name: Sayar Banerjee
 *  Date: 20/03/2020
 *  Description: Deque implementation
 *****************************************************************************/

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }


    public Deque() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item) {

        if (item == null) throw new IllegalArgumentException("Please enter arguments.");
        Node newfirst = new Node();
        newfirst.item = item;
        newfirst.prev = null;
        newfirst.next = first;
        if (isEmpty()) {
            last = newfirst;
        }
        else {
            first.prev = newfirst;
        }
        first = newfirst;
        N++;

    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Please enter arguments.");
        Node newlast = new Node();
        newlast.item = item;
        newlast.prev = last;
        newlast.next = null;
        if (isEmpty()) {
            first = newlast;
        }
        else {
            last.next = newlast;
        }

        last = newlast;
        N++;

    }

    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Deque is empty.");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        else {
            first.prev = null;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Deque is empty.");
        Item item = last.item;
        N--;
        last = last.prev;
        if (isEmpty()) {
            first = null;
        }
        else {
            last.next = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("No such operation.");
        }

        public Item next() {
            if (current == null) throw new java.util.NoSuchElementException("No such element");
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        int n = 5;
        Deque<Integer> dq = new Deque<Integer>();
        for (int i = 0; i < n; i++) {
            dq.addLast(i);

        }
        for (int i : dq) {
            StdOut.print(i);
        }
        System.out.println();
        dq.removeFirst();
        for (int i : dq) {
            StdOut.print(i);
        }
        System.out.println();
        dq.removeLast();

        for (int i : dq) {
            StdOut.print(i);
        }


    }
}




