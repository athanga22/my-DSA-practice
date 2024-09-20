package Graph;
import java.util.*;

public class CC {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        int cc=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, visited, adj);
                cc++;
            }
        }
        return cc;
    }
    private void dfs(int node, boolean[] visited, List<List<Integer>> adj){
        Stack<Integer> stk=new Stack<>();
        stk.push(node);
        visited[node]=true;
        while(!stk.isEmpty()){
            int v=stk.pop();
            for(int n:adj.get(v)){
                if(!visited[n]){
                    stk.push(n);
                    visited[n]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        CC graph = new CC();
        int n1 = 5;
        int[][] edges1 = { {0, 1}, {1, 2}, {3, 4} };
        int result1 = graph.countComponents(n1, edges1);
        System.out.println("Number of connected components in the first graph: " + result1);

        int n2 = 6;
        int[][] edges2 = { {0, 1}, {2, 3}, {3, 4}, {5, 5} };
        int result2 = graph.countComponents(n2, edges2);
        System.out.println("Number of connected components in the second graph: " + result2);
    }
}
