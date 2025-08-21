class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m)return false;

        char[] ch = s1.toCharArray();
        Arrays.sort(ch);
        String s = new String(ch);

        for(int i =0; i<= m-n ;i++){
            String subs = s2.substring(i , i+n);
            char[] wor = subs.toCharArray();
            Arrays.sort(wor);
            String new_s = new String(wor);

            if(s.equals(new_s))return true; 
        }
        return false;
    }
}
