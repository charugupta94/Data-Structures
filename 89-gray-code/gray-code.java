class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        solve(res, n);
        return res;
    }
    public static void solve(List<Integer> res, int n){
        if(n == 1){
            res.add(0);
            res.add(1);
            return;
        }
        
        List<Integer> arr = new ArrayList<>();
        solve(res , n - 1);
        for(int i = res.size()-1; i>= 0;i--){
            arr.add(res.get(i));
        }
        for(int i: arr){
            int val = (int)Math.pow(2, n-1);
            res.add( i+ val);
        }
    }
}