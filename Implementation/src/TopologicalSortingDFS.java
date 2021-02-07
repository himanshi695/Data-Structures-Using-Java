import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
    }
    static void DFS(ArrayList<ArrayList<Integer>> adj, int u, Stack<Integer> st, boolean[] visited){
        visited[u]=true;
        for (int k: adj.get(u)){
            if (visited[k]==false){
                DFS(adj, k, st, visited);
            }
        }
        st.push(u);
    }
    static void topologicalSortDFS(ArrayList<ArrayList<Integer>> adj, int v){
        boolean visited[]=new boolean[v];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < v ; i++) {
            if (visited[i]==false){
                DFS(adj, i ,st, visited);
            }
        }
        while (st.empty()==false){
            int l=st.pop();
            System.out.print(l + " ");
        }
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v ; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,0, 1);
        addEdge(adj,1, 3);
        addEdge(adj,2, 3);
        addEdge(adj,3, 4);
        addEdge(adj,2, 4);
        topologicalSortDFS(adj, v);
    }

}
