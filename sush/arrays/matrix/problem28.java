class Solution {
    public void setZeroes(int[][] matrix) {
        int matRows = matrix.length;
        int matCols = matrix[0].length;
        
        int[] refRow = new int[matRows];
        int[] refCol = new int[matCols];
        
        for(int i=0; i<matRows; i++){
            for(int j=0; j<matCols; j++){
                if(matrix[i][j]==0){
                    refRow[i] = 1;
                    refCol[j] = 1;
                }
            }
        }
        for(int i=0; i<matRows; i++){
            if(refRow[i]==1){
                for(int j=0; j<matCols; j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0; j<matCols; j++){
            if(refCol[j]==1){
                for(int i=0; i<matRows; i++){
                    matrix[i][j]=0;
                }
            }
        }
        return;
    }
}
