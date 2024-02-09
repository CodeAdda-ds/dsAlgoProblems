 Count the min time in which we will be able to rot all the oranges, if at all

this example will teach us:
 - how to traverse in an adjacency matrix use BFS
 - what exactly to store in queue
 - how to set multiple starting points of BFS

https://www.geeksforgeeks.org/problems/rotten-oranges2536/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotten_oranges

```java
class Solution
{
    static class Pair {
        int row;
        int col;
        int time;
        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int totalTime = 0;
        int cntFreshInitial = 0;
        Queue<Pair> q = new LinkedList<>(); // queue me vo sab store karo jo har state pe change hoga
        int[][] visited = new int[n+1][m+1];
        // this for loop is just to set the starting points for our BFS
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==2) {
                    visited[i][j] = 1;
                    q.add(new Pair(i, j, totalTime));
                }
                if (grid[i][j]==1) cntFreshInitial++; // to keep a count of initial fresh oranges
            }
        }
        
        int[] xDirs = {-1,0,1,0};
        int[] yDirs = {0,1,0,-1};
        int cntRotten = 0;
        while(!q.isEmpty()) {
            int currRow = q.peek().row;
            int currCol = q.peek().col;
            int currTime = q.peek().time;
            totalTime = Math.max(totalTime, currTime);
            q.poll();
            
            // go to its neighbours
            // in adj matrix, this is how we can go to the node's neighbours
            for(int i=0; i<4; i++) {
                int newX = currRow + xDirs[i];
                int newY = currCol + yDirs[i];
                // condition based on which we will rot the orange
                if(newX >= 0 && newX < n && newY >= 0 && newY < m && visited[newX][newY]==0 && grid[newX][newY]==1) {
                    q.add(new Pair(newX, newY, currTime+1));
                    visited[newX][newY] = 2;
                    cntRotten++;
                }
            }
        }
        if (cntRotten!=cntFreshInitial) {
            return -1;
        }
        return totalTime;
    }
}
```
