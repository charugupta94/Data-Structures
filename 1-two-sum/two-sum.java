class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     int[] arr = new int[2];
    //     for(int i = 0;i<nums.length;i++){
    //         if(nums[i] < target){
    //             int rem = target - nums[i];
    //             int idx = -1;
    //             for(int j = i+1;j<nums.length ; j++){
    //                 if(nums[j] == rem){
    //                     idx = j;
    //                     break;
    //                 }
    //             }
    //             if(idx != -1){
    //                 arr[0] = i;
    //                 arr[1] = idx;
    //             }
    //         }
    //     }
    //     return arr;
    // }



    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if(map.containsKey(rem)) {
                return new int[] { map.get(rem), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}