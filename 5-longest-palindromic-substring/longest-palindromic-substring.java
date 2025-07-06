class Solution {
    public boolean palindrome(String s , int i , int j){
        while(i < j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(ch1 != ch2){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i< s.length() ; i++){
            for(int j = i ; j< s.length() ;j++){
                if(palindrome(s , i , j)){
                    if(j-i+1 > max){
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        System.out.println(start+" "+end);
        return s.substring(start, end+1);
    }
}