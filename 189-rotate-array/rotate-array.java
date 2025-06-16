class Solution {
    public void reverse(int[] nums , int low, int high){
        while(low < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }



    //TLE 
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;
    //     k = k % n;  
    //     while (k > 0) {
    //         int last = nums[n - 1];
    //         for (int i = n - 1; i > 0; i--) {
    //             nums[i] = nums[i - 1];
    //         }
    //         nums[0] = last;
    //         k--;
    //     }
    // }
}