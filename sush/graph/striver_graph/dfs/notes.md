![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/636a55f6-fd1a-4ce4-be76-cd2d8d8363fe)

![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/3aea6517-3cae-4ba4-822e-b8ca68e84f98)

// to refer the driver code: https://github.com/striver79/StriversGraphSeries/blob/main/DfsJava

```java
class Solution
{
    public void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
        storeDfs.add(node); 
        visited[node] = true; 
        for(Integer it: adj.get(node)) {
            if(visited[it] == false) {
                dfs(it, visited, adj, storeDfs); 
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int vertices, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> storeDfs = new ArrayList<>(); 
        boolean visited[] = new boolean[vertices+1]; 
        for(int i = 1;i<=vertices;i++) {
            if(!visited[i])
                dfs(i, visited, adj, storeDfs); 
        }
        
        return storeDfs;
    }
}
```

- Time: O(N + E)
- Space: O(N+E) + O(N) + O(N)
