package Graph;
import java.util.*;
public class CycleBFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(bfs(i, visited, adj)) return true;
            }
        }
        return false;
    }
    public boolean bfs(int s, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{s, -1});
        visited[s]=true;
        while(!q.isEmpty()){
            int[] n=q.poll();
            int curr=n[0];
            int parent=n[1];
            for(int ele: adj.get(curr)){
                if(!visited[ele]){
                    q.add(new int[]{ele, curr});
                    visited[ele]=true;
                }
                else if(ele!=parent) return true;
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
