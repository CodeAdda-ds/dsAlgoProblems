// remember that we need to only apply checks on the cell we're in
// to handle neighbours, simply pass them in the recursive function and it will all be taken care of

class Solution {
    public void helper(int[][] image, int row, int col, int color, int newColor){
        
        if(row < 0 || col < 0 || row>=image.length || col>= image[0].length) {
            return;
        }
        if(image[row][col]!=color){
            return;
        }
        image[row][col] = newColor;
        helper(image, row-1, col, color, newColor);
        helper(image, row, col-1, color, newColor);
        helper(image, row+1, col, color, newColor);
        helper(image, row, col+1, color, newColor);
        return;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
}
