class Solution {
    public int scheduleCourse(int[][] courses) {
        int d = 0;
        int count = 0;
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i< courses.length;i++){
            if(courses[i][0] <= courses[i][1] && d+courses[i][0] <= courses[i][1]){
                d += courses[i][0];
                pq.add(courses[i][0]);
                count++;
            }
            else if(!pq.isEmpty()){
                int max = pq.peek();
                if(max > courses[i][0]){
                    d -= pq.poll();
                    d += courses[i][0];
                    pq.add(courses[i][0]);
                }
            }
        }
        return count; 
    }
}