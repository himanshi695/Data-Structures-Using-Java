public class NQueenProblem {
    static int n=4;
    static int board[][] = { { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 } };

    static boolean isSafe(int row, int col){
        for (int i = 0; i < col ; i++) {
            if (board[row][i]==1){
                return false;
            }
        }
        for (int i = row, j=col; j>=0 && i >=0 ; i--, j--) {
            if (board[i][j]==1){
                return false;
            }
        }
        for (int i = row, j=col; i <n && j>=0 ; i++,j--) {
            if (board[i][j]==1){
                return false;
            }
        }
        return true;
    }
    static boolean solveRec(int col){
        if (col==n){
            return true;
        }
        for (int i = 0; i < n ; i++) {
            if (isSafe(i,col)){
                board[i][col]=1;
                if (solveRec(col+1)){
                    return true;
                }
                board[i][col]=0;
            }
        }
        return false;
    }
    static boolean solve(){
        if (solveRec(0)==false){
            return false;
        }
        printMatrix(board);
        return true;
    }

    static void printMatrix(int[][] board) {
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
