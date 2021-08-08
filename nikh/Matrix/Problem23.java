class Solution {
    public int up(char[][] board,int r,int c)
    {
        
        while(r>=0)
        {
            if(board[r][c]=='p')
                return 1;
            if(board[r][c]=='B')
                return 0;
            r--;
        }
        return 0;
    }
    public int down(char[][] board,int r,int c)
    {
       
        while(r<8)
        {
            if(board[r][c]=='p')
                return 1;
            if(board[r][c]=='B')
                return 0;
            r++;
        }
        return 0;
    }
    public int left(char[][] board,int r,int c)
    {
        
        while(c>=0)
        {
            if(board[r][c]=='p')
                return 1;
            if(board[r][c]=='B')
                return 0;
            c--;
        }
        return 0;
    }
    public int right(char[][] board,int r,int c)
    {
        
        while(c<8)
        {
            if(board[r][c]=='p')
                return 1;
            if(board[r][c]=='B')
                return 0;
            c++;
        }
        return 0;
    }
    public int numRookCaptures(char[][] board) {
        int x=0,y=0;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(board[i][j]=='R')
                {
                    x=i;
                    y=j;
                }
            }
        }
        int count= up(board,x,y)+down(board,x,y)+left(board,x,y)+right(board,x,y);
        return count;
    }
}