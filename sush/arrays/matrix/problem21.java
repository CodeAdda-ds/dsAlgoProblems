class Solution {
    public void transpose(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;                
            }
        }
    }
    public void flip(int[][] matrix){
        int l = matrix.length;
        for(int i=0; i<l; i++){
            for(int j=0; j<l/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][l-j-1];
                matrix[i][l-j-1] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }
}
