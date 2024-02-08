- breadth generally signifies level wise traversal as well

![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/7584e8cb-9bf0-49dc-b7a2-3fa811e6e593)

- only one node can be at level 0
- if the traversal starts a node which is not the top one, you need to think about the distance of other nodes from the starting point. All nodes equidistant
  from the starting point will fall at the same level
  
![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/f098366a-524b-44e3-8448-aeb7a848fa22)

- To implement BFS, the initial configuration should have a queue DS and a visited array(size n+1) and mark the starting node as 1 in array.
- We take the node out of the queue and print it
- Then we ask "who are your neighbours?" (adj list will have that info), we put them all in the queue(only those who are not visited) and mark them visited

general code which will be written in the function which is given in question

```
for ( i --> 0 to n )
    if (visited[i]==0)
        bfs(i)
```

// you can check out the driver code from here if required: https://github.com/striver79/StriversGraphSeries/blob/main/BfsJava

```java
class Solution
{
    public ArrayList<Integer> bfsOfGraph(int vertices, ArrayList<ArrayList<Integer>> adj)
    {
        
        ArrayList<Integer> bfs = new ArrayList<>(); // will store our traversal
        boolean visited[] = new boolean[vertices+1]; // 1-based indexing 
        
        for(int i=1; i <= vertices; i++){
            if(visited[i]==false){

                // yahan se bfs ka asli logic shuru hota hai
                // iske pehle apan ne wahi likha jo main me likhne ki baat ki thi
                Queue<Integer> q = new LinkedList<>(); // queue can be of self created data type as well if we need to store more info
                q.add(i); // if in some question, there are more than one starting points we'll need to add all of those in queue
                visited[i] = true;

                while (!q.isEmpty())
                {
                    Integer node = q.poll(); // take topmost and delete it
                    bfs.add(node); // we perform operation on node here, like we are adding to our answer array here
        
                    // Get all adjacent neighbours of the dequeued node
                    // If an adjacent node has not been visited, then mark it
                    // visited and enqueue it
                    for(Integer it: adj.get(node)) {
                        if(visited[it] == false) {
                            visited[it] = true; 
                            q.add(it); 
                        } 
                    }
                }
            }
        }
        
        
        
        return bfs; 

    }
}
```



Time: O(N + 2E)
Space: O(N+E) + O(N) + O(N)

