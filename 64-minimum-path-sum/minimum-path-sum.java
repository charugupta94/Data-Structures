class Solution {
    public int f(int idx1 , int idx2, int[][] grid, int[][] dp){
        if(idx1 == 0 && idx2 == 0) return grid[idx1][idx2];
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1)return dp[idx1][idx2];

        int up = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(idx1 > 0)up = grid[idx1][idx2] + f(idx1 -1,idx2 , grid , dp);
        if(idx2 > 0)right = grid[idx1][idx2] + f(idx1,idx2- 1, grid , dp);

        return dp[idx1][idx2] = Math.min(up, right);
    }
    
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i =0 ;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(n-1,m-1,grid,dp);
    }
    // public int minPathSum(int[][] grid){
    //     for(int i=0;i<n;i++){
    //         for(int j =0;j<m;j++){
    //             if(i == 0 && j == 0) dp[i][j] = grid[i][j];
    //             else{
    //                 int up = 1000000007;
    //                 int left = 1000000007;

    //                 if(i > 0 ) up = grid[i][j] + dp[i-1][j];
    //                 if(j > 0) left = grid[i][j]+ dp[i][j-1];

    //                 dp[i][j]= Math.min(up , left);
    //             }
    //         }
    //     }
    //     return dp[n-1][m-1];
    // }
}