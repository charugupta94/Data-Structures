class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        f(result, "" , 0 ,0 , n);
        return result;
    }
    public void f(List<String> result , String curr ,int open , int close , int n){
        if(curr.length() == 2 * n){
            if(isValid(curr)){
                result.add(curr);
            }
        }
        if(open < n){
            f(result , curr + "(" , open + 1 , close , n);
        }
        if(close <= open){
            f(result ,curr + ")" , open , close + 1 , n);
        }  
    }

    public boolean isValid(String curr){
        int n = curr.length();
        int count = 0;
        for(int i = 0 ; i < n ;i++){
            if(curr.charAt(i) == '(')count++;
            if(curr.charAt(i) == ')')count--;
            if(count < 0)return false;
        }
        return true;
    }
}
