import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class AdjListNode{
    private int v;
    private int w;
    AdjListNode(int a, int b){
        this.v=a;
        this.w=b;
    }
    int getV(){
        return v;
    }
    int getW(){
        return w;
    }
}
class ShortestPathInADAG{
    private int v;
    private LinkedList<AdjListNode> adj[];
    ShortestPathInADAG(int k){
        this.v=k;
        adj=new LinkedList[v];
        for (int i = 0; i < v ; i++) {
            adj[i]=new LinkedList<AdjListNode>();
        }
    }
    void addEdge(int u, int v, int w){
        AdjListNode node=new AdjListNode(v,w);
        adj[u].add(node);
    }
    void topologicalSortUtil(int v, boolean[] visited, Stack stack) {
        visited[v] = true;
        Iterator<AdjListNode> it = adj[v].iterator();
        while (it.hasNext()) {
            AdjListNode node=it.next();
            if (!visited[node.getV()]){
                topologicalSortUtil(node.getV(),visited, stack);
            }
        }
        stack.add(v);
    }
    void shortestPath(int s){
        Stack stack =new Stack();
        int dist[]=new int[v];
        boolean visited[]=new boolean[v];
        for (int i = 0; i < v ; i++) {
            if (visited[i]==false){
                topologicalSortUtil(i,visited,stack);
            }
        }
        for (int i = 0; i < v ; i++) {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[s]=0;
        while (stack.empty()==false){
            int u=(int) stack.pop();
            Iterator<AdjListNode> it;
            if (dist[u]!=Integer.MAX_VALUE){
                it=adj[u].iterator();
                while (it.hasNext()){
                    AdjListNode i=it.next();
                    if (dist[i.getV()]>dist[u]+i.getW()){
                        dist[i.getV()]=dist[u]+i.getW();
                    }
                }
            }
        }
        for (int i = 0; i < v ; i++) {
            if (dist[i]==Integer.MAX_VALUE){
                System.out.print("INF" + " ");
            } else{
                System.out.print(dist[i] + " ");
            }
        }
    }
}
class Main{
    public static void main(String[] args) {
        ShortestPathInADAG s=new ShortestPathInADAG(6);
        s.addEdge(0, 1, 2);
        s.addEdge(0, 4, 1);
        s.addEdge(1, 2, 3);
        s.addEdge(4, 2, 2);
        s.addEdge(4, 5, 4);
        s.addEdge(2, 3, 6);
        s.addEdge(5, 3, 1);
        int source=0;
        s.shortestPath(source);
    }
}
