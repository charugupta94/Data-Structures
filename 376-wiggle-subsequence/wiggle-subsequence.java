class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 0) continue;

            if (arr.isEmpty()) {
                arr.add(diff);
            } else {
                int lastDiff = arr.get(arr.size() - 1);
                if ((lastDiff >= 0 && diff < 0) || (lastDiff <= 0 && diff > 0)) {
                    arr.add(diff);
                }
            }
        }
        return arr.size() + 1;
    }
}
