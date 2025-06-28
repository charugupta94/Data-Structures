class Solution {
    class Pair {
        int val, index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> b.val - a.val);

        Pair[] topK = new Pair[k];
        for (int i = 0; i < k; i++) {
            topK[i] = arr[i];
        }

        Arrays.sort(topK, (a, b) -> a.index - b.index);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK[i].val;
        }

        return res;
    }
}
