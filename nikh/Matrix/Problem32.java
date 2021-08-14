Solution-1
class Solution {
    public int minPathSum(int[][] grid) {
        for(int i=1;i<grid.length;i++)
        {
            grid[i][0]+=grid[i-1][0];
        }
        for(int j=1;j<grid[0].length;j++)
        {
            grid[0][j]+=grid[0][j-1];
        }
        for(int i=1;i<grid.length;i++)
        {
            for(int j=1;j<grid[0].length;j++){
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}

Solution-2(Time Limit Exceeded for large numbers)
class Solution {
    int minSum;
    public void findMin(int[][] grid,int r,int c,int sum)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==-1)
            return;
        sum=sum+grid[r][c];
        if(r==grid.length-1 && c==grid[0].length-1){
            minSum = Math.min(sum,minSum);
            return;
        }
        int temp=grid[r][c];
        grid[r][c]=-1;
        findMin(grid,r-1,c,sum);
        findMin(grid,r+1,c,sum);
        findMin(grid,r,c-1,sum);
        findMin(grid,r,c+1,sum);
        grid[r][c]=temp;
        return;
    }
    
    public int minPathSum(int[][] grid) {
        int sum =0;
        minSum = Integer.MAX_VALUE;
        findMin(grid,0,0,sum);
        return minSum;
    }
}