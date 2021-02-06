import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        //because of directed graph////////////////////////////////////////////
        adj.get(u).add(v);
    }
    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v){
        int indegree[]=new int[v];
        for (int i = 0; i < v ; i++) {
            for (int x: adj.get(i)){
                indegree[x]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < v ; i++) {
            if (indegree[i]==0){
                q.add(i);
            }
        }
        while (q.isEmpty()==false){
            int u=q.poll();
            System.out.print(u + " ");
            for (int k: adj.get(u)){
                if (--indegree[k]==0){
                    q.add(k);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v ; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);

        topologicalSort(adj,v);
    }

}
