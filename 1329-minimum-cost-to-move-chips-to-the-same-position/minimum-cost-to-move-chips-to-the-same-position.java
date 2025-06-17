class Solution {
    public int minCostToMoveChips(int[] position) {
        int evencount =0;
        int oddcount = 0;
        for(int i=0;i<position.length;i++){
            if(position[i]%2 == 0){
                evencount++;
            }
            else{
                oddcount++;
            }
        }
        return Math.min(evencount,oddcount);
    }
}