public class PrimsAlgorithm {
    static int primMST(int graph[][], int v){
        int key[]=new int[v];
        for (int i = 0; i < v ; i++) {
            key[i]=Integer.MAX_VALUE;
        }
        key[0]=0;
        boolean mst[]=new boolean[v];
        int res=0;
        for (int i = 0; i < v ; i++) {
            int k=-1;
            for (int j = 0; j < v ; j++) {
                if (mst[j]==false && (k==-1 || key[j]<key[k])){
                    k=i;
                }
            }
            mst[k]=true;
            res+=key[k];
            for (int j = 0; j < v ; j++) {
                if (mst[j]==false && graph[k][j]!=0 && graph[k][j]<key[j]){
                    key[j]=graph[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int v = 4;
        int graph[][] = new int[][]{{0, 5, 8, 0},
                {5, 0, 10, 15},
                {8, 10, 0, 20},
                {0, 15, 20, 0},};
        System.out.println(primMST(graph,v));
    }
}
