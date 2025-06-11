class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // int[] arr = new int[m+n];
        int size = m+n; 
        int idx1 = size/2-1;
        int element1 = -1;
        int idx2 = (size/2);
        int element2 = -1;
        int i = 0;
        int temp = 0;
        int temp2 = 0;
        while(temp < m && temp2 < n){
            if(nums1[temp] < nums2[temp2]){
                if(i == idx1){
                    element1 = nums1[temp];
                }
                if(i == idx2){
                    element2 = nums1[temp];
                }
                temp++;
            }
            else{
                if(i == idx1){
                    element1 = nums2[temp2];
                }
                if(i == idx2){
                    element2 = nums2[temp2];
                }
                temp2++;
            }
            i++;
        }
        while(temp < m){
                if(i== idx1){
                    element1 = nums1[temp];
                }
                if(i == idx2){
                    element2 = nums1[temp];
                }
                temp++;
                i++;
        }
        while(temp2 < n){
            if(i == idx1){
                    element1 = nums2[temp2];
                }
                if(i == idx2){
                    element2 = nums2[temp2];
                }
                temp2++;
                i++;
        } 
        if(size%2 == 1){
            return element2;
        }
        return (element1 + element2)/2.0;
    }
}