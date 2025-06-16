class Solution {
    // public void reverse(int[] nums , int low, int high){
    //     while(low < high){
    //         int temp = nums[low];
    //         nums[low] = nums[high];
    //         nums[high] = temp;
    //         low++;
    //         high--;
    //     }
    // }
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;
    //     k = k % n;
    //     reverse(nums, 0, n-1);
    //     reverse(nums,0,k-1);
    //     reverse(nums,k,n-1);
    // }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0; 
        int start = 0;
        while (count < n) {
            int current = start;
            int prev = nums[start];

            while (true) {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;

                if (start == current) break; 
            }
            start++; 
        }
    }

    
}