class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(f(n-1, cost ,dp) , f(n-2 , cost, dp));
    }
    public int f(int idx , int[] cost , int[] dp){
        if(idx == 0)return cost[0];
        if(idx == 1)return cost[1];

        if(dp[idx] != -1)return dp[idx];

        int one = f(idx -1, cost , dp) + cost[idx];
        int two = f(idx -2, cost , dp) + cost[idx];
        dp[idx] = Math.min(one,two);
        return dp[idx];
    }
}