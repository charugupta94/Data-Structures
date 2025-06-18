class Solution {
    public int singleNonDuplicate(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while(l < r){
            int m = l + (r- l)% 2;
            if(m % 2 != 0)m--;

            if(arr[m] == arr[m+1]){
                l = m + 2;
            }
            else{
                r = m;
            }
        }
        return arr[l];
    }
}