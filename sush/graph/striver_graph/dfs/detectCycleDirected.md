[problem link](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph)

<img width="1084" alt="image" src="https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/39f92e72-9839-46e5-8344-0b65deb4beb0">

Idea:
- problem with the undirected approach is that even if we see node visited, that still doesn't mean that there is cycle
- we will maintain a list of visitedPath as well, wherein we'll mark it 1 for time dfs call has been made for startingNode. In this way, we'll have a path covered by startingNode.
- When are about to return out of dfs call, we mark the visitedpath as 0 again because we're getting out of the path of startingNode.
- So, when we'll again see that an adjacentNode has been visietd AND in the same path, that means that there is a cycle.
  <img width="1089" alt="image" src="https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/c9483222-b7fc-41e0-a1ca-de2059c9e3e6">

```java
class Solution {
    boolean dfsCheck(int start, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] visitedPath) {
        visited[start] = 1;
        visitedPath[start] = 1; // we are marking our path
        
        for(int adjacentNode : adj.get(start)) {
            if(visited[adjacentNode]==0) {
                if(dfsCheck(adjacentNode, adj, visited, visitedPath)==true) return true;
            } else if(visitedPath[adjacentNode]==1){ // if adjacent node is already visited and also in the path
                return true;
            }
        }
        visitedPath[start] = 0; // because we have completed the dfs run for this node, so mark it to initial value taki agle wale ke path me include na ho jaye
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V+1];
        int[] visitedPath = new int[V+1];
        Arrays.fill(visited, 0);
        Arrays.fill(visitedPath, 0);
        
        for(int i=0; i<V; i++) {
            if(visited[i]==0) {
                if(dfsCheck(i, adj, visited, visitedPath)==true) return true;
            }
        }
        return false;
    }
}
```
Tip: Always think about what would you return by default if found nothing matching(in this case false)
Time Complexity: O(V + E)
Space Complexity: O(V + E) + O(V) + O(V)
