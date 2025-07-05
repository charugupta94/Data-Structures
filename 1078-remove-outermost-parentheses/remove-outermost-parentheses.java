class Solution {
    // public String removeOuterParentheses(String s) {
    //     Stack<Character> st = new Stack<>();
    //     StringBuilder ans = new StringBuilder();
    //     for(int i = 0; i< s.length() ;i++){
    //         char ch = s.charAt(i);
    //         if(!st.isEmpty() && ch =='('){
    //             st.add(ch);
    //             ans.append(ch);
    //         }
    //         else if(!st.isEmpty() && ch == ')'){
    //             char top = st.peek();
    //             if(top == '('){
    //                 st.pop();
    //                 if(!st.isEmpty()){
    //                     ans.append(ch);
    //                 }
    //             }
    //         }
    //         else{
    //             st.add(ch);
    //         }
    //     }
    //     String res = ans.toString();
    //     return res;
    // }


    public String removeOuterParentheses(String s){
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int n = s.length();
        for(int i =0 ;i < n; i++){
            char ch = s.charAt(i);
            if(ch ==')') c--;
            if(c !=0 ) sb.append(ch);
            if(ch =='(') c++;
        }
        return sb.toString();
    }
}