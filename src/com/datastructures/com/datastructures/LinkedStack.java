package com.datastructures;

public class LinkedStack {
    private Node first = null;
    private class Node
    {
        String s;
        Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void push(String item)
    {
        Node oldfirst = first;
        Node first = new Node();
        first.s = item;
        first.next = oldfirst;
    }

    public String pop()
    {
        String item = first.s;
        first = first.next;
        return item;
    }
}
