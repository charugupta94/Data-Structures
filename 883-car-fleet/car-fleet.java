class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer , Integer> mp = new HashMap<>();
        int  n = position.length;
        for(int  i =0 ;i< n ; i++){
            mp.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        double t[] = new double[n];
        for(int i = 0; i< n ;i++){
            t[i] = (double)(target - position[i]) /(double) mp.get(position[i]);
        }

        int count = 1;
        double x = t[n - 1];
        for(int  i =n - 2; i>=0 ;i--){
            if(t[i] > x){
                count++;
                x = t[i];
            }
        }
        return count;
    }
}