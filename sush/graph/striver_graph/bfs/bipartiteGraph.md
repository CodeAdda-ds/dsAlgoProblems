A graph will be bipartite if the nodes can be coloured with two colours in such a way that no adjacent nodes should have the same colour.

- A linear graph with no cycle will always be bipartite
- A graph with even numbered node cycle can also be bipartite
- A graph with odd numbered node cycle will not be a bipartite graph

Now, for working out the solution, we just need to check while traversing if adjacent nodes have the same colour that means it's not bipartite graph.

```java
class Solution
{
    boolean bfs(int startingNode, ArrayList<ArrayList<Integer>> adj, int[] colours) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startingNode);
        colours[startingNode] = 0;
        
        while(!q.isEmpty()) {
            int currNode = q.poll();
            
            // dealing with neighbours
            for(int adjacentNode : adj.get(currNode)) {
                // if adjacentNode is unvisited, assign it the opposite colour to currNode
                if(colours[adjacentNode]==-1) { 
                    colours[adjacentNode] = 1 - colours[currNode];
                    q.add(adjacentNode);
                } else if(colours[adjacentNode]==colours[currNode]) { // found same colours, not allowed
                    return false;
                }
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
                boolean failureStatusFromBFS = bfs(i, adj, colours);
                if (!failureStatusFromBFS) return false;
            }
        }
        return true;
    }
}
```
