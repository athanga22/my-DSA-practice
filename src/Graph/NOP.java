package Graph;
import java.util.*;

public class NOP {
    private void dfs(int node, boolean[] visited, List<List<Integer>> adj){
        Stack<Integer> stk=new Stack<>();
        stk.push(node);
        visited[node]=true;
        while(!stk.isEmpty()){
            int v=stk.pop();
            for(int n: adj.get(v)){
                if(!visited[n]){
                    stk.push(n);
                    visited[n]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj=new ArrayList<>();
        boolean[] visited=new boolean[isConnected.length+1];
        for(int i=0;i<isConnected.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    adj.get(i+1).add(j+1);
                }
            }
        }
        int cc=0;
        for(int i=1;i<isConnected.length+1;i++){
            if(!visited[i]){
                dfs(i, visited, adj);
                cc++;
            }
        }
        return cc;
    }

    public static void main(String[] args) {
        NOP graph = new NOP();

        int[][] isConnected1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int result1 = graph.findCircleNum(isConnected1);
        System.out.println("Number of provinces in example 1: " + result1);

        int[][] isConnected2 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };
        int result2 = graph.findCircleNum(isConnected2);
        System.out.println("Number of provinces in example 2: " + result2);
    }
}
