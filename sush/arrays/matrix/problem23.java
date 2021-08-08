
// Solution 1 which looks like can be shortened
// Although it is faster than 100% java sols but the code isn't pretty, one day I'll try to shorten it

class Solution {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        int rookPosition[] = {0,0};
        for(int i=0; i< 8; i++){
            for(int j=0; j<8; j++){
                if(board[i][j]=='R'){
                    rookPosition[0] = i;
                    rookPosition[1]=j;
                    break;
                }
            }
        }
        // horizontal left
        int j=rookPosition[1];
        boolean bishop = false;
        while(j>=0){
            if(board[rookPosition[0]][j]=='B'){
                bishop = true;
                break;
            }
            if(board[rookPosition[0]][j]=='p' && !bishop){
                count += 1;
                break;
            }
            j--;
        }
        // horizontal right
        j = rookPosition[1];
        bishop = false;
        while(j<8){
            if(board[rookPosition[0]][j]=='B'){
                bishop = true;
                break;
            }
            if(board[rookPosition[0]][j]=='p' && !bishop){
                count += 1;
                break;
            }
            j++;
        }
        // vertical up
        int i = rookPosition[0];
        bishop = false;
        while(i>=0){
            if(board[i][rookPosition[1]]=='B'){
                bishop = true;
                break;
            }
            if(board[i][rookPosition[1]]=='p' && !bishop){
                count += 1;
                break;
            }
            i--;
        }
        //vertical down
        i = rookPosition[0];
        bishop = false;
        while(i<8){
            if(board[i][rookPosition[1]]=='B'){
                bishop = true;
                break;
            }
            if(board[i][rookPosition[1]]=='p' && !bishop){
                count += 1;
                break;
            }
            i++;
        }
        return count;
        
    }
}
