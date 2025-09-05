class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        f(0 ,path, res, s);
        return res;
    }
    public void f(int idx,List<String> path ,List<List<String>> res , String s){
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx ; i< s.length() ; i++){
            if(palindrome(idx , i , s)){
                path.add(s.substring(idx , i + 1));
                f(i + 1 , path,res,s);
                path.remove(path.size() - 1);
            }
        }
    }
    public boolean palindrome(int l , int r , String s){
        while(l <= r){
            if(s.charAt(l) != s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
}