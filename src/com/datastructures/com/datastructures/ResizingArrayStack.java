package com.datastructures;

public class ResizingArrayStack {
    private String[] items;
    private int N = 0;

    private  ResizingArrayStack() {
        items = new String[1];
    }
    public void push(String item){
        if (N >= items.length){resize(2 * items.length);}
        items[N++] = item;

    }

    public String pop(){
        String item = items[--N];
        if(N <= 1/4 * items.length){ resize(1/2 * items.length);}
        return item;
    }

    private void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i=0; i < N; i++){
            copy[i] = items[i];
        }
        items = copy;
    }
}
