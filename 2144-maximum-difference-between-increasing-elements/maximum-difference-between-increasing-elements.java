class Solution {
    public int maximumDifference(int[] nums) {
        int maxdiff = 0;
        int diff  = 0;
        int a = nums[0];
        for(int i = 1 ;i<nums.length;i++){
            if(nums[i] > a){
                diff = nums[i] - a;
            }
            else if(nums[i] < a){
                a = nums[i];
            }
            maxdiff = Math.max(diff , maxdiff);
        }
        if(maxdiff  == 0)return -1;
        return maxdiff;
    }
}