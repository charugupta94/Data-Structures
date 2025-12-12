class Solution {
    public int f(int idx1 , int idx2 , String s1 , String s2, int[][] dp){
        if(idx1 < 0 || idx2 < 0)return 0;
        if(dp[idx1][idx2] != -1)return dp[idx1][idx2];
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            dp[idx1][idx2] = 1 + f(idx1 - 1 , idx2 - 1 , s1 ,s2,dp);
        }
        else{
            dp[idx1][idx2] = Math.max(f(idx1 -1 , idx2, s1,s2,dp), f(idx1 , idx2 -1 , s1 ,s2,dp));
        }
        return dp[idx1][idx2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp =new int[n][m];
        for(int i =0 ;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return f(n-1,m-1,text1, text2,dp);
    }
}