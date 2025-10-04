class Solution {
    public int maxArea(int[] height) {
        int ans =0;
        int n = height.length;
        int start = 0;
        int end = n-1;
        for(int i=0;i<n;i++){
            int x = Math.min(height[start], height[end]);
            int y = end - start;
            int area = x * y;
            ans = Math.max(area,ans);
            if(height[start] < height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return ans;
    }
}