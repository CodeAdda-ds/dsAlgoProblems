class Solution {
    public int islandPerimeter(int[][] grid) {
        int p=0,s;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                s=0;
                if(grid[i][j]==1){
                    s = 4;
                    if(i+1<grid.length && grid[i+1][j]==1)
                        s--;
                    if(i-1>=0 && grid[i-1][j]==1 )
                        s--;
                    if(j+1<grid[i].length && grid[i][j+1]==1)
                        s--;
                    if(j-1>=0 && grid[i][j-1]==1)
                        s--;
                }
                p=p+s;
            }
        }
        return p;
    }
}