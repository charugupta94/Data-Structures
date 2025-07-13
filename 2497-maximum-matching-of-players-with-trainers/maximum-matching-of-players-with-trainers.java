class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int n = players.length - 1;
        int m = trainers.length - 1;
        int count = 0 ;
        while( n >= 0 && m >= 0){
            if(trainers[m] >= players[n]){
                count++;
                m--;
            }
            n--;
        }
        return count;
    }
}