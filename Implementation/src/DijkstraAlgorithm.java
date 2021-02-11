public class DijkstraAlgorithm {
    static int[] Dijkstra(int graph[][], int source){
        int v=graph.length;
        int dist[]=new int[v];
        for (int i = 0; i < v ; i++) {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[source]=0;
        boolean[] fin=new boolean[v];
        for (int i = 0; i < v-1 ; i++) {
            int u=-1;
            for (int j = 0; j < v ; j++) {
                if (fin[j]==false && (u==-1 || dist[i]<dist[u])){
                    u=j;
                }
            }
            fin[u]=true;
            for (int j = 0; j < v ; j++) {
                if (fin[j]==false && graph[u][j]!=0){
                    dist[j]=Math.min(dist[j],dist[u]+graph[u][j]);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 50, 100, 0},
                { 50, 0, 30, 200 },
                { 100, 30, 0, 20 },
                { 0, 200, 20, 0 },};
        int k[]= Dijkstra(graph,0);
        for (int i = 0; i < k.length ; i++) {
            System.out.print(k[i] + " ");
        }
    }
}
