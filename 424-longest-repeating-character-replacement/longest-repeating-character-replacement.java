class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxfreq =0;
        int maxlen =0;
        int[] set = new int[26];
        while(right < s.length()){
            char ch = s.charAt(right);
            set[ch - 'A']++;
            maxfreq = Math.max(maxfreq , set[ch - 'A']);

            while((right - left +1) - maxfreq > k){
                set[s.charAt(left) - 'A']--;
                maxfreq = 0;
                for(int i = 0; i<26;i++){
                    maxfreq = Math.max(maxfreq , set[i]);
                }
                left++;
            }

            maxlen = Math.max(maxlen , right - left + 1);

            right++;
        }
        return maxlen ;
    }
}
