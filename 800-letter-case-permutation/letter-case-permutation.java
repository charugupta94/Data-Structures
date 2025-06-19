class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        possibleString(s.toCharArray(),0,res);
        return res;

    }
    public static void possibleString(char[] s , int idx ,List<String> res){
        if(idx == s.length){
            res.add(new String(s));
            return ;
        }
        else if(Character.isLetter(s[idx])){
            s[idx] = Character.toLowerCase(s[idx]);
            possibleString(s, idx+1 , res);

            s[idx] = Character.toUpperCase(s[idx]);
            possibleString(s, idx+1 , res);
        }
        else{
            possibleString(s, idx+1 , res);
        }
    }
}