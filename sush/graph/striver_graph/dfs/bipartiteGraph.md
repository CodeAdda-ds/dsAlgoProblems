[Bipartite Graph problem link](https://www.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph)

Since the colour will change for every recusrive call stage, we need to pass colour in the recursive dfs call as well

```java
class Solution
{
    boolean dfs(int node, int colour, ArrayList<ArrayList<Integer>> adj, int[] colours) {
        // passing colour as well because it will change at every recursive stage,
        // we can't just assign 0 like in BFS
        colours[node] = colour; 
        for(int adjacentNode: adj.get(node)) {
            if (colours[adjacentNode]==-1) {
                if (dfs(adjacentNode, 1-colour, adj, colours)==false) return false;
            } else if(colours[adjacentNode]==colours[node]){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] colours = new int[V+1];
        Arrays.fill(colours, -1); // to mention uncoloured nodes
        
        for(int i=0; i<V; i++) {
            if(colours[i]==-1) { // not visited yet
                if (dfs(i, 0, adj, colours)== false) return false;
            }
        }
        return true;
    }
}
```
