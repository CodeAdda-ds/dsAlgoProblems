package striver_graph;
import java.io.*;
    

public class AdjacencyMatrix {
	public static void main (String[] args) {
		int n = 3, m = 3; // vertices and edges
		int adj[][] = new int[n+1][n+1]; 
		
		// edge 1---2
		adj[1][2] = 1;
		adj[2][1] = 1; 
		
		
		// edge 2---3
		adj[2][3] = 1; 
		adj[3][2] = 1; 
		
		
		// adge 1--3
		adj[1][3] = 1;
		adj[3][1] = 1; 
		
	}
}

// we could have also created an adjacency matrix of boolean type
// and stored true/false instead of 0/1


