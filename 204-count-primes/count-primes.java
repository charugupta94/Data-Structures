class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isprime = new boolean[n+1];
        Arrays.fill(isprime, true);
        isprime[0] = false;
        if(n > 1){
            isprime[1] = false;
        }
        for(int i = 2; i*i <= n  ; i++){
            if(isprime[i] == true){
                for(int j = i*i ; j<= n;j+= i){
                    isprime[j] = false;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(isprime[i] == true){
                count++;
            }
        }
       return count;
    }
}