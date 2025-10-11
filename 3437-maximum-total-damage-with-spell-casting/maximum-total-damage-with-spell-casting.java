class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + 1);
        }
        List<Integer> uniqueValues = new ArrayList<>(map.keySet());
        Collections.sort(uniqueValues);

        long[] dp = new long[uniqueValues.size()];
        if (uniqueValues.size() == 0) return 0;

        dp[0] = uniqueValues.get(0) * map.get(uniqueValues.get(0));

        for (int i = 1; i < uniqueValues.size(); i++) {
            int currentValue = uniqueValues.get(i);
            long currentTotalDamage = currentValue * map.get(currentValue);

            long include = currentTotalDamage;
            int indexToExclude = i - 1;
            while (indexToExclude >= 0 && (currentValue - uniqueValues.get(indexToExclude)) <= 2) {
                indexToExclude--;
            }
            if (indexToExclude >= 0) {
                include += dp[indexToExclude];
            }
            long exclude = dp[i - 1];

            dp[i] = Math.max(include, exclude);
        }

        return dp[uniqueValues.size() - 1];
    }
}