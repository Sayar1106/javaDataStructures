package com.datastructures.com.datastructures;
import java.util.*;

class Node{
    int val;
    public Node(int v){
        this.val = v;
    }
}

public class Graph{
    private int V;
    private List<Node>[] adj;
    public Graph(int v){
        this.V = v;
        this.adj = new LinkedList[v];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<Node>();
        }
    }
    public void addEdge(Node n1, Node n2){
        adj[n1.val].add(n2);
    }

    public void DFS(Node n){
        boolean visited[] = new boolean[V];
        DFSUtil(n, visited);
    }

    private void DFSUtil(Node n, boolean visited[]){
        visited[n.val] = true;
        System.out.println("Node" + n.val + "has been reached");
        Iterator<Node> i = adj[n.val].listIterator();
        while(i.hasNext()){
            Node next = i.next();
            if(!visited[next.val]){
                DFSUtil(next, visited);
            }
        }
    }
    public static void main(String args[]){
        Graph graph = new Graph(3);
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        graph.addEdge(one, two);
        graph.addEdge(one, zero);
    }
}
