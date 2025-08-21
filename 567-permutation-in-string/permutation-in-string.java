class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m)return false;

        // char[] ch = s1.toCharArray();
        // Arrays.sort(ch);
        // String s = new String(ch);

        // for(int i =0; i<= m-n ;i++){
        //     String subs = s2.substring(i , i+n);
        //     char[] wor = subs.toCharArray();
        //     Arrays.sort(wor);
        //     String new_s = new String(wor);

        //     if(s.equals(new_s))return true; 
        // }
        // return false;

        int[] freq_s1 = new int[26];
        int[] freq_s2 = new int[26];
        for(char ch : s1.toCharArray()){
            freq_s1[ch - 'a']++;
        }
        int left = 0;
        int right =0;
        while(right < m){
            if(right - left + 1 > n){
                freq_s2[s2.charAt(left) - 'a']--;
                left++;
            }
            freq_s2[s2.charAt(right) - 'a']++;
            if(Arrays.equals(freq_s1 , freq_s2)){
                return true;
            }
            right++;
        }
        return false;
    }
}
