class Solution {
    class Pair{
        int idx;
        double dist;
        Pair(int idx , double dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dist, a.dist));
        for(int i = 0; i< points.length;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            double ans = Math.sqrt(x1 * x1 + y1 * y1);
            pq.offer(new Pair(i, ans));

            if(pq.size() > k)pq.poll();
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i<k;i++){
            Pair p1 = pq.poll();
            ans[i][0] = points[p1.idx][0];
            ans[i][1] = points[p1.idx][1];
        }
        return ans;
    }
}
