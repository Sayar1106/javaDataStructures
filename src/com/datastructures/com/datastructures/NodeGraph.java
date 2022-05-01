package com.datastructures.com.datastructures;
import java.util.*;

class Node{
    int val;
    public Node(int v){
        this.val = v;
    }
}

public class NodeGraph{
    private int V;
    private LinkedList<Node> adj[];
    public NodeGraph(int v){
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

	public void BFS(Node n){
		boolean visited[] = new boolean[V];
		Node prev[] = new Node[V];
		BFSUtil(n, visited, prev);
	}

	private void BFSUtil(Node n, boolean visited[], Node prev[]){
		Queue<Node> queue = new LinkedList();
        System.out.println("Node" + n.val + "has been reached");
		queue.add(n);
		visited[n.val] = true;
		while(!queue.isEmpty()){
			Node curr = queue.remove();
			Iterator<Node> iter = adj[curr.val].listIterator();
			while(iter.hasNext()){
				Node next = iter.next();
				if(!visited[next.val]){
					queue.add(next);
					visited[next.val] = true;
					System.out.println("Node" + next.val + "has been reached");
					prev[next.val] = curr;
				}
			}
		}
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
        NodeGraph graph = new NodeGraph(13);
        Node nodeList[] = new Node[13];
        for(int i = 0; i < nodeList.length; i++){
            nodeList[i] = new Node(i);
        }
        graph.addEdge(nodeList[0], nodeList[9]);
        graph.addEdge(nodeList[0], nodeList[7]);
        graph.addEdge(nodeList[0], nodeList[11]);
        graph.addEdge(nodeList[9], nodeList[10]);
        graph.addEdge(nodeList[9], nodeList[8]);
        graph.addEdge(nodeList[7], nodeList[3]);
        graph.addEdge(nodeList[7], nodeList[6]);
        graph.addEdge(nodeList[10], nodeList[1]);
        graph.addEdge(nodeList[8], nodeList[1]);
        graph.addEdge(nodeList[8], nodeList[12]);
        graph.addEdge(nodeList[3], nodeList[2]);
        graph.addEdge(nodeList[3], nodeList[4]);
        graph.addEdge(nodeList[6], nodeList[5]);
        graph.addEdge(nodeList[12], nodeList[2]);
        graph.BFS(nodeList[0]);
    }
}
