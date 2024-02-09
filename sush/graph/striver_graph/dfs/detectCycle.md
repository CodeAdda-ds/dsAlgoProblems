Detect if an undirected graph is cyclic [problem link](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph)
- in the dfs call, we don't care if we found false, only return false if everything has been checked and we still didn't get true

```java
class Solution {

    public boolean dfs(int node,int parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        // all the adjacent nodes will be checked and dfs call will be made
        for(int adjacentNode : adj.get(node)) {
            if(visited[adjacentNode]==0) {
                if (dfs(adjacentNode, node, adj, visited)) return true; // only return true if we found true
            } else if(parent != adjacentNode) return true; 
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int i=0; i<V; i++) {
            if(visited[i]==0) {
                // check the cycle by keeping every node as starting point
                boolean foundCycle = dfs(i, -1, adj, visited);
                if (foundCycle) {
                    return true;
                }
            }
            
        }
        return false;
    }
}
```
