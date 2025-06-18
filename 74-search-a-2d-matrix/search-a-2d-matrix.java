class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            int midval = matrix[mid / matrix[0].length][mid % matrix[0].length];

            if(midval > target){
                r = mid-1;
            }
            else if(midval < target){
                l = mid + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}