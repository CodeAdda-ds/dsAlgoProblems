
Solution-1
class Solution {
    public void find(char[][] grid,int r,int c)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!='1')
            return;
        grid[r][c]='0';
        find(grid,r+1,c);
        find(grid,r-1,c);
        find(grid,r,c+1);
        find(grid,r,c-1);
        return;
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    find(grid,i,j);
                }
            }
        }
        return count;
    }
}

Solution-2
class Solution {
   boolean[][] b = new boolean[301][301];
    public void find(char[][] grid,int r,int c)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!='1' || b[r][c]==true)
            return;
        b[r][c]=true;
        find(grid,r+1,c);
        find(grid,r-1,c);
        find(grid,r,c+1);
        find(grid,r,c-1);
        return;
    }
    public int numIslands(char[][] grid) {
        int count=0;
         
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1' && b[i][j]==false)
                {
                    count++;
                    find(grid,i,j);
                }
            }
        }
        return count;
    }
}