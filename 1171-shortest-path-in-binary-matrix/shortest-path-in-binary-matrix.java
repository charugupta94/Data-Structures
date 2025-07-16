class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row , int col, int dist){
            this.row = row;
            this.col = col;
            this.dist =  dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0) return -1;
        q.add(new Pair(0,0,1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            if(row == n-1 && col == m-1)return dist;
            visited[row][col] = 1;
            int[] dx = {-1,-1,0,1,1,1,0,-1};
            int[] dy = {0,1,1,1,0,-1,-1,-1};
            for(int i=0;i<8;i++){
                int r = row + dx[i];
                int c = col + dy[i];
                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 0 && visited[r][c] == 0){
                    visited[r][c] = 1;
                    q.add(new Pair(r,c,dist +1));
                }
            }
        }

        return -1;
    }
    
}