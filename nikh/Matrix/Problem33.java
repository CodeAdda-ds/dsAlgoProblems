class Solution {
    public void dfs(char[][] board,int r,int c)
    {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!='O')
            return;
        board[r][c]='Z';
        dfs(board,r-1,c);
        dfs(board,r+1,c);
        dfs(board,r,c-1);
        dfs(board,r,c+1);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m==1 || n<=2)
            return;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0 || i==m-1 || j==n-1)
                {
                    if(board[i][j]=='O')
                        dfs(board,i,j);
                }
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]!='Z')
                    board[i][j]='X';
                else
                    board[i][j]='O';
            }
        }
    }
}