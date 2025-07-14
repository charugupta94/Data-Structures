class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n ;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(n-1, m-1,obstacleGrid ,dp);
    }
    public int f(int idx1 , int idx2 ,int[][] obstacleGrid, int[][] dp){
        if(idx1 < 0 || idx2 < 0)return 0;
        if(obstacleGrid[idx1][idx2] == 1)return 0;
        if(idx1 == 0 && idx2 == 0)return 1;
        if(dp[idx1][idx2] != -1)return dp[idx1][idx2];
        int left =0;
        int down =0;
        if(idx1 > 0) left = f(idx1 - 1,idx2,obstacleGrid, dp);
        if(idx2 > 0) down = f(idx1,idx2 -1,obstacleGrid,dp);

        return dp[idx1][idx2] = left + down;
    }
}