package Graph;
import java.util.*;
public class CycleDFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i, visited, adj)) return true;
            }
        }
        return false;
    }
    public boolean dfs(int s, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        Stack<int[]> stk=new Stack<>();
        stk.push(new int[]{s, -1});
        visited[s]=true;
        while(!stk.isEmpty()){
            int[] n=stk.pop();
            int curr=n[0];
            int parent=n[1];
            for(int i:adj.get(curr)){
                if(!visited[i]){
                    stk.push(new int[]{i, curr});
                    visited[i]=true;
                }
                else if(parent!=i) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(1);
        adj.get(1).add(4);

        CycleBFS cycleDetector = new CycleBFS();

        if (cycleDetector.isCycle(V, adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }

}
