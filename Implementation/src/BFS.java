import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static void bfs(ArrayList<ArrayList<Integer>> adj, int v, int s){
        boolean visited[]=new boolean[v+1];
        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.add(s);
        while (q.isEmpty()==false){
            int u=q.poll();
            System.out.print(u + " ");
            for (int k: adj.get(u)) {
                if (visited[k]==false){
                    visited[k]=true;
                    q.add(k);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v ; i++) {
            adj.add(new ArrayList<Integer>());
        }
        Graph.addEdge(adj,0,1);
        Graph.addEdge(adj, 0,2);
        Graph.addEdge(adj,1,2);
        Graph.addEdge(adj,1,3);
        bfs(adj,v,0);
    }
}
