class Solution {
    public int findLucky(int[] arr) {
        int freq[] = new int[501];
        for(int  i =0 ;i < arr.length;i++){
            freq[arr[i]]++;
        }
        int lucky = -1;
        for(int i=0;i<501;i++){
            if(i == 0) continue;
            if(freq[i] == i){
                lucky = i;
            }
        }
        return lucky;
    }
}