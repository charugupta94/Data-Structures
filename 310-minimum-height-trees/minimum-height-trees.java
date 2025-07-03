class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node ,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> center = new ArrayList<>();
        if(n == 1){
            center.add(0);
            return center;
        }
        if(n == 2){
            center.add(edges[0][0]);            
            center.add(edges[0][1]);
            return center;        
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int  i = 0 ; i< n ; i++){
            adj.add(new ArrayList<>());
        } 
        for(int edge[] : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] parent = new int[n];
        Pair A = farthestnode(0 , adj, parent);
        parent = new int[n];
        Pair B = farthestnode(A.node , adj, parent);
        List<Integer> path = dfs(B.node , parent , A.node);
        int distance = B.dist;
        if(distance % 2 == 0){
            center.add(path.get(distance/2));
        }
        else{
            center.add(path.get(distance/2));
            center.add(path.get(distance/2 + 1));
        }

        return center;
    }
    public Pair farthestnode(int start , List<List<Integer>> adj , int[] parent){
        int[] visited = new int[parent.length];
        Arrays.fill(visited, -1);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start , 0));
        visited[start] = 1;
        Pair farthest = new Pair(start , 0);

        while(!q.isEmpty()){
            Pair p = q.poll();
            farthest = p;
            for(int neighbour: adj.get(p.node)){
                if(visited[neighbour] != 1){
                    q.add(new Pair(neighbour , p.dist + 1));
                    visited[neighbour] = 1;
                    parent[neighbour] = p.node;
                }
            } 
        }

        return farthest;
    }
    
    public List<Integer> dfs(int start, int[] parent, int target) {
        List<Integer> path = new ArrayList<>();
        int curr = start;
        while (curr != target) {
            path.add(curr);
            curr = parent[curr];
        }
        path.add(target);
        Collections.reverse(path);
        return path;
    }
}