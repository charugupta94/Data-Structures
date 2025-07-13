class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int first = players.length - 1;
        int last = trainers.length - 1;
        int n = 0 , m = 0;
        int count = 0 ;
        while( n <= first && m <= last){
            if(trainers[m] >= players[n]){
                count++;
                n++;
            }
            m++;
        }
        return count;
    }
}