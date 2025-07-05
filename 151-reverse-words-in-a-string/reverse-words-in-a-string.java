class Solution {
    // public String reverseWords(String s) {
    //     s = reverse(s);
    //     StringBuilder ans = new StringBuilder();
    //     String words[] = s.split("\\s+");
    //     for(int i =0 ;i< words.length ;i++){
    //         String c = words[i];
    //         c = reverse(c);
    //         if(i < words.length - 1){
    //             ans.append(c).append(" ");
    //         }
    //         else{
    //             ans.append(c);
    //         }
    //     }
    //     return ans.toString().trim();
    // }
    // public String reverse(String s){
    //     StringBuilder sb = new StringBuilder(s);
    //     int l = 0;
    //     int r = sb.length() - 1;
        
    //     while (l < r) {
    //         char c = sb.charAt(l);
    //         sb.setCharAt(l, sb.charAt(r));
    //         sb.setCharAt(r, c);
    //         l++;
    //         r--;
    //     }
    //     return sb.toString();
    // }

    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for(int i = words.length - 1; i >= 0;i--){
            reversed.append(words[i]);
            if( i > 0){
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }
}