package com.datastructures.com.datastructures;
import java.util.*;

public class Graph {
    private final int V;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        // If the graph is undirected, the reverse statement will not hold.
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.println(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }

        }
    }

    void DFS(int v){
        // This array marks all vertices as not visited
        boolean[] visited = new boolean[V];
        // Call the helper function
        DFSUtil(v, visited);
    }
    public static void main(String args[]) 
    { 
        Graph g = new Graph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.DFS(2); 
    } 
}
