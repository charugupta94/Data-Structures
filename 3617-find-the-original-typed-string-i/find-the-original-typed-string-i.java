class Solution {
    public int possibleStringCount(String word) {
        int length = word.length();
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                count++;
            }
        }
        return count+1;
    }
}