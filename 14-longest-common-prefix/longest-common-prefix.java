class Solution {
    public String longestCommonPrefix(String[] strs) {
        // StringBuilder res = new StringBuilder();
        // String str ="";
        // int min = 0;
        // for(String i: strs){
        //     if(min > i.length()){
        //         str = i;
        //         min = i.length();
        //     }
        // }
        // char[] c = str.toCharArray();
        // int[] freq = new int[c.length];
        // int j = 0;
        // for(String i : strs){
        //     if(j < c.length && i.charAt(j)){
        //         freq[j++];
        //     }
        // }

        String first = strs[0];

        for(int i = 0 ;i < first.length() ;i++){
            char c = first.charAt(i);
            for(int j = 1; j < strs.length ; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }
}