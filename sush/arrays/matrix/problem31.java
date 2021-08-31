class Solution {
    public void dfsCall(char[][] grid, int row, int col, int m, int n){
        if(row<0 || col <0 || row >=m || col >= n){
            return;
        }
        // main condition of our dfs call
        if(grid[row][col]!='1'){
            return;
        }
        // marked as visited
        grid[row][col]=2;
        
        dfsCall(grid, row-1, col, m, n); 
        dfsCall(grid, row+1, col, m, n); 
        dfsCall(grid, row, col-1, m, n);
        dfsCall(grid, row, col+1, m, n);
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j]=='1'){
                    dfsCall(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
}
