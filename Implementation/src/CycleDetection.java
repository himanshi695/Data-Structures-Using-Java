import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
    }
    static void cycleDetection(ArrayList<ArrayList<Integer>> adj, int v){
        int indegree[]=new int[v];
        for (int i = 0; i < v ; i++) {
            for (int a: adj.get(i)){
                indegree[a]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < v ; i++) {
            if (indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while (q.isEmpty()==false){
            int u=q.poll();
            for (int x:adj.get(u)){
                indegree[x]--;
                if (indegree[x]==0){
                    q.add(x);
                }
            }
            count++;
        }
        if (count!=v){
            System.out.println("There exists a cycle.");
        } else{
            System.out.println("There dont exist a cycle");
        }
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v ; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0, 1);
        addEdge(adj,4, 1);
        addEdge(adj,1, 2);
        addEdge(adj,2, 3);
        addEdge(adj,3, 1);
        cycleDetection(adj,v);
    }
}
