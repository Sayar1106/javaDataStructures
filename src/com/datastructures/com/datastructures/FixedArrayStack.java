package com.datastructures;

public class FixedArrayStack
{
    private String[] s;
    private int N = 0;

    public FixedArrayStack(int capacity)
    {
        s = new String[capacity];
    }

    public boolean isEmpty()
    { return N == 0; }


    public void push(String item)
    {
        s[N++] = item;
    }

    public String pop()
    {
        String pop_item = s[--N];
        s[N] = null;
        return pop_item;
    }

}
