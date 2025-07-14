class Solution {
    public int f(int i, int j, int[][] dp){
        if(i == 0 && j == 0)return 1;
        if(i<0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int up = f(i-1 ,j,dp);
        int left = f(i,j-1,dp);

        return dp[i][j] = up + left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        // for(int i = 0; i <= m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return f(m-1,n-1,dp);
        for(int i = 0 ;i<m;i++){
            for(int j = 0 ;j<n ;j++){
                if(i == 0 && j == 0) dp[0][0] = 1;
                else{
                    int right = 0;
                    int down = 0;
                    if(i > 0) {
                        down = dp[i-1][j];
                    }
                    if(j > 0){
                        right = dp[i][j-1];
                    }
                    dp[i][j] = down + right;
                }
            }
        }
        return dp[m-1][n-1];
    }
}