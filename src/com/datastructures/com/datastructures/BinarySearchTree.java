package com.datastructures;

public class BinarySearchTree <Key extends Comparable<Key>, Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int N;
        public Node(Key key, Value value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
    public int size(Node node){
        if(node == null) return 0;
        return node.N;
    }
    public void put(Key key, Value value){
        root = put(root, key, value);
    }
    private Node put(Node node, Key key, Value value){
        if(node == null) return new Node(key, value, 1); // Base case: Insert when there is a null link.
        if(node.key.compareTo(key) < 0) node.left = put(node.left, key, value);
        if(node.key.compareTo(key) > 0) node.right = put(node.right, key, value);
        else node.value = value;

        node.N = size(node.left) + size(node.right) + 1; // Invariant to keep track of size.

        return node;
    }
    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node node, Key key){
        if(node == null) return null;
        if(node.key.compareTo(key) < 0) return get(node.left, key);
        if(node.key.compareTo(key) > 0) return get(node.right, key);
        else return node.value;
    }
    public Key max(){
        Node max = max(root);
        return max.key;
    }
    private Node max(Node node){
        if(node.left == null) return node;
        return max(node.left);
    }
    public Key min(){
        Node min = min(root);
        return min.key;
    }
    private Node min(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }
    public Key floor(Key key){
        Node floor = floor(root, key);
        if(floor == null) return null;
        return floor.key;
    }
    private Node floor(Node node, Key key){
        if(node == null) return null;
        if(node.key.compareTo(key) == 0) return node;
        if(node.key.compareTo(key) < 0) return floor(node.left, key);
        if(node.key.compareTo(key) > 0);
    }
    public Value delete(Key key){}
}
