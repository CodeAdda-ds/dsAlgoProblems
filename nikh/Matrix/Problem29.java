class Solution {
    public boolean check(char[][] board,int r,int c,int index,String word)
    {
        
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || index>=word.length() || board[r][c]!=word.charAt(index))
            return false;
        if(index==word.length()-1)
            return true;
       char temp=board[r][c];
       board[r][c]='0';
        boolean b=false;;
       if(check(board,r-1,c,index+1,word)==true || check(board,r+1,c,index+1,word)==true || check(board,r,c-1,index+1,word)==true || check(board,r,c+1,index+1,word)==true){
           b=true;
       } 
        board[r][c]=temp;
        
       return b;
    }
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                   
                    if(check(board,i,j,0,word)==true)
                        return true;
                }
            }
        }
        return false;
    }
}