import java.util.ArrayList;

public class Graph {
    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v ; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,0,1);
        addEdge(adj, 0,2);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        printGrapg(adj);
    }

    private static void printGrapg(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size() ; i++) {
            for (int j = 0; j < adj.get(i).size() ; j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int v, int u){
        adj.get(v).add(u);
        adj.get(u).add(v);
    }
}
