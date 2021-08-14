class Solution {
    public void perform(int[][] image,int sr,int sc,int color,int newColor)
    {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length)
            return;
        if(image[sr][sc]!=color)
            return;
        image[sr][sc]=newColor;
        perform(image,sr,sc-1,color,newColor);
        perform(image,sr,sc+1,color,newColor);
        perform(image,sr-1,sc,color,newColor);
        perform(image,sr+1,sc,color,newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color==newColor)
            return image;
        perform(image,sr,sc,color,newColor);
        return image;
    }
}