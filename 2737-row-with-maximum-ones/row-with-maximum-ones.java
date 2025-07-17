class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int [] ans = new int [2];
        int index = 0;
        int maxCount = -1;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int n : mat[i]) {
                count += n;
            }

            if (count > maxCount) {
                index = i;
                maxCount = count;
            }

        }

        ans[0] = index;
        ans[1] = maxCount;

        return ans;
        
    }

    // public int[] rowAndMaximumOnes(int[][] mat) {
    //     HashMap<Integer, Integer> mp = new HashMap<>();
    //     for(int i =0 ;i<mat.length ;i++){
    //         int count = 0;
    //         for(int j = 0;j<mat[0].length ;j++){
    //             if(mat[i][j] == 1){
    //                 count++;
    //             }
    //         }
    //         mp.put(i,count);
    //     }
    //     int row = -1;
    //     int max= -1;

    //     for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
    //         int rowidx = entry.getKey();
    //         int count = entry.getValue();
            
    //         if(count > max || (count == max && rowidx < row)){
    //             max = count;
    //             row = rowidx;
    //         }
    //     }

    //     int[] res = new int[2];
    //     res[0] = row;
    //     res[1] = max;
    //     return res;
    // }
}