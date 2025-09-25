class Solution {
    public int f(int i , int j , List<List<Integer>> triangle ,int n,int[][] dp ){
        if(i == n-1) return triangle.get(n-1).get(j);

        if(dp[i][j] != -1) return dp[i][j];
        int d = triangle.get(i).get(j) + f(i+1,j,triangle,n,dp);
        int diag = triangle.get(i).get(j) + f(i+1,j+1,triangle,n,dp);

        return dp[i][j] = Math.min(d,diag);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        // for(int i =0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return f(0,0,triangle,n,dp);
        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i = n-2;i>=0;i--){
            for(int j = i;j>= 0 ;j--){
                int d = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j)+ dp[i+1][j+1];
                dp[i][j] = Math.min(d,diag);
            }
        }
        return dp[0][0];
    }
}