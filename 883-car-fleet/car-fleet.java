class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer , Integer> mp = new HashMap<>();
        for(int  i =0 ;i< position.length ; i++){
            mp.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        double t[] = new double[position.length];
        for(int i = 0; i< position.length ;i++){
            t[i] = (double)(target - position[i]) /(double) mp.get(position[i]); 
            System.out.print(t[i]);
        }

        int count = 1;
        double x = t[t.length - 1];
        for(int  i = t.length - 2; i>=0 ;i--){
            if(t[i] > x){
                count++;
                x = t[i];
            }
        }
        return count;
    }
}