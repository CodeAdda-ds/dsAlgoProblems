/*
general code which will be written in the function which is given in question

for ( i --> 0 to n )
    if (visited[i]==0)
        bfs(i)

*/

// you can check out the driver code from here if required: https://github.com/striver79/StriversGraphSeries/blob/main/BfsJava

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
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty())
                {
                    Integer node = q.poll(); // take topmost and delete it
                    bfs.add(node); // we perform operation on node here, like we are adding to our answer array here
        
                    // Get all adjacent vertices of the dequeued node
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

/*

Time: O(N + E)
Space: O(N+E) + O(N) + O(N)

*/