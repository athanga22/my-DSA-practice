package Graph;

import java.util.Arrays;

public class floodFill {
    public int[][] ff(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int newColor){
        if(sr>=image.length || sr<0 || sc>=image[0].length || sc<0 || image[sr][sc]!=color) return;
        image[sr][sc]=newColor;
        dfs(image, sr+1, sc, color, newColor);
        dfs(image, sr, sc+1, color, newColor);
        dfs(image, sr-1, sc, color, newColor);
        dfs(image, sr, sc-1, color, newColor);
    }
    public static void main(String[] args) {
        // Define a sample 2D image (each element represents a pixel color)
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        floodFill ff = new floodFill();

        int[][] result = ff.ff(image, sr, sc, newColor);

        System.out.println("Modified Image:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
