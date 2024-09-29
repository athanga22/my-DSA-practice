package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int r, c, time;
    Pair(int r, int c, int time){
        this.r = r;
        this.c = c;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();

        int fresh=0;
        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==1){
                    vis[i][j]=0;
                    fresh++;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int[] row={-1, 1, 0, 0}, col={0, 0, -1, 1};
        int tm=0, cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().r;
            int c=q.peek().c;
            int t=q.peek().time;
            tm=Math.max(tm, t);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+row[i];
                int nc=c+col[i];
                if(nr<m && nr>=0 && nc<n && nc>=0 && vis[nr][nc]==0 && grid[nr][nc]==1){
                    q.add(new Pair(nr, nc, t+1));
                    vis[nr][nc]=2;
                    cnt++;
                }
            }
        }
        if(fresh!=cnt) return -1;
        return tm;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int result = solution.orangesRotting(grid);
        System.out.println("Minimum time to rot all oranges: " + result);
    }
}