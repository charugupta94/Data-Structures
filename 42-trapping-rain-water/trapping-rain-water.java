class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                prefix[i] = height[i];
            }
            else{
                prefix[i] = Math.max(prefix[i-1],height[i]);
            }
        }
        for(int i = n-1;i>=0;i--){
            if(i== n-1){
                suffix[i] = height[n-1];
            }
            else{
                suffix[i] = Math.max(suffix[i+1],height[i]);
            }
        }
        int water = 0;
        for(int i=0;i<n;i++){
            water += Math.min(prefix[i],suffix[i]) - height[i];
        }
        return water;
    }
}