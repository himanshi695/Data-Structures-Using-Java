public class LCS {
    static int dp[][];
    static int lcs(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        dp =new int[m+1][n+1];
        for (int i = 0; i <=m; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i <=n ; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1="AGGTAB";
        String s2="GXTXAYB";
        System.out.println(lcs(s1,s2));

    }
}