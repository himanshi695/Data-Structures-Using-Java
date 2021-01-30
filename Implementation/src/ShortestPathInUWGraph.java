import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUWGraph {
    static void shortestpath(ArrayList<ArrayList<Integer>> adj, int v, int s, boolean[] visited){
        int dist[]=new int[v];
        dist[s]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        visited[s]=true;
        while (q.isEmpty()==false){
            int u=q.poll();
            for (int k: adj.get(u)){
                if (visited[k]==false){
                    dist[k]=dist[u]+1;
                    visited[k]=true;
                    q.add(k);
                }
            }
        }
        print(dist);
    }

    static void print(int[] dist) {
        for (int i = 0; i < dist.length ; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int v = 4;
        boolean visited[]=new boolean[v];
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(v);

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());

        Graph.addEdge(adj,0,1);
        Graph.addEdge(adj,1,2);
        Graph.addEdge(adj,2,3);
        Graph.addEdge(adj,0,2);
        Graph.addEdge(adj,1,3);
        shortestpath(adj,v,0,visited);

    }
}
