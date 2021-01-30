import java.util.ArrayList;

public class DFS {
    static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited){
        visited[s]=true;
        System.out.print(s + " ");
        for (int k: adj.get(s)){
            if (visited[k]==false){
                visited[k]=true;
                DFSRec(adj, k, visited);
            }
        }
    }
    static void DFS(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v ; i++) {
            if (visited[i]==false){
                DFSRec(adj,i,visited);
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
        Graph.addEdge(adj,3,4);
        DFS(adj,v);
    }


}
