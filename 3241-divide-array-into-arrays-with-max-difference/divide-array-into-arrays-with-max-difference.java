class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n =  nums.length;
        int[][] res = new int[n/3][3];
        int group = 0;
        for(int i=0;i<n;i+=3){
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }
            res[group][0] = nums[i];
            res[group][1] = nums[i+1];
            res[group][2] = nums[i+2];
            group++;
        }
        return res;
    }
}