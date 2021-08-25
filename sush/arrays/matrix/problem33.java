class Solution {
    // this dfs call will simply replace the target with the toFill
    public void dfsCall(char[][] board, int x, int y, char target, char toFill){
        if(x < 0 || x >=board.length || y < 0 || y >= board[0].length){
            return;
        }
        if(board[x][y]==target){
            board[x][y] = toFill;
            dfsCall(board, x-1, y, target, toFill);
            dfsCall(board, x+1, y, target, toFill);
            dfsCall(board, x, y-1, target, toFill);
            dfsCall(board, x, y+1, target, toFill);
        }
        return;    
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m == 0 || n == 0){
            return;
        }
        char toFill = '*';
        
        // if we get a boundary cell, replace it with a temporary star just to know that it'll be not changed
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1){
                    dfsCall(board, i, j, 'O', toFill);
                }
            }
        }
        
        // now leaving the boundary cells, replace the Os with Xs
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j]=='O'){
                    dfsCall(board, i, j, 'O', 'X');
                }
            }
        }
        
        // finally revert back the changes we made earlier
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='*'){
                    dfsCall(board, i, j, '*', 'O');
                }
            }
        }
        return;
    }
}
