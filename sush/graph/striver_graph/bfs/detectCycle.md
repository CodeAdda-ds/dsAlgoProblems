<img width="1046" alt="image" src="https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/c836f0a4-e22b-470a-93c0-a3ca0e1ff7db">Detect if a cycle exists in an undirected graph: [problem link](https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqblNkZlBUVi1HMWtIMUtLejJkdUV5SENqTzZ5QXxBQ3Jtc0tsLVI2VUk3TE13d1RfUzhHZW9UejZzNkp2SHRUT2VxUjR1QkFrWlhYZTkwOWdiSlpOOGJqLVN4STZtb0g0ZUV0TFByMm5EemhOcFZURW1UWVdkM05Mb2dFRi02OUl2TlhZcXh2dkNFZk5NOTE0aTJyZw&q=https%3A%2F%2Fbit.ly%2F3cZMJXp&v=BPlrALf1LDU)
- just apply BFS
- store the parent in the queue as well (-1 as parent for the starting point)
- if a node is already visited when we reach it and it didn't come from our parent
   - that means it must've been visited by someone else
   - by we started in different directions from the starting point
   - that means, this node was visited from some other direction i.e. cycle is there (in the ex we got this for 6 -> 7, 7 was already visited)


```java
class Solution {
    static class Pair {
        int node;
        int parent;
        
        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    // detects if a cycle exists from the starting point
    public boolean detectCycle(int startingPoint, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startingPoint, -1));
        visited[startingPoint] = 1;
        
        while(!q.isEmpty()) {
            int currNode = q.peek().node;
            int parent = q.peek().parent;
            q.poll();
            
            // deal with neighbours
            for(Integer adjacentNode : adj.get(currNode)) {
                if(visited[adjacentNode]==0) {
                    visited[adjacentNode] = 1;
                    q.add(new Pair(adjacentNode, currNode));
                } else if(adjacentNode != parent) { // adjacentNode had been reached through some other path
                    return true;
                }
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int i=0; i<V; i++) {
            if(visited[i]==0) {
                // check the cycle by keeping every node as starting point
                boolean foundCycle = detectCycle(i, adj, visited);
                if (foundCycle) {
                    return true;
                }
            }
            
        }
        return false;
    }
}
```
