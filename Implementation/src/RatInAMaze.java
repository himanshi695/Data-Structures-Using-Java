public class RatInAMaze {
    static int n;
    static boolean isSafe(int i, int j, int maze[][]){
        return i<n && j<n && maze[i][j]==1;
    }
    static boolean solveMaze(int maze[][]){
        int sol[][]=new int[n][n];
        if (solveMazeRec(0,0,sol,maze)==false){
            System.out.println("Solution doesn't exist.");
            return false;
        }
        printsol(sol);
        return true;
    }

    static void printsol(int arr[][]) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean solveMazeRec(int i, int j, int sol[][], int maze[][]){
        if(i== n-1 && j==n-1 && maze[i][j]==1){
            sol[i][j]=1;
            return true;
        }
        if (isSafe(i,j,maze)==true){
            sol[i][j]=1;
            if (solveMazeRec(i+1,j,sol,maze)==true){
                return true;
            }
            else if (solveMazeRec(i,j+1,sol,maze)==true){
                return true;
            }
            sol[i][j]=0;
        }
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        n=maze.length;
        solveMaze(maze);
    }
}
