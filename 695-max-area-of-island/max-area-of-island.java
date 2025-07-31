class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int visited[][] = new int[n][m];
        int dx[] ={-1,0,1,0};
        int dy[] ={0,1,0,-1};
        int maxCount =0; 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 1 && visited[i][j] != 1){
                    q.add(new Pair(i,j));
                    visited[i][j] = 1;
                    int count = 1;
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        int r = p.row;
                        int c = p.col;
                        for(int k = 0 ; k < 4; k++){
                            int row = r + dx[k];
                            int col = c + dy[k];
                            if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && visited[row][col] != 1){
                                q.add(new Pair(row , col));
                                visited[row][col] = 1;
                                count++;
                            }
                        }
                    }
                    maxCount = Math.max(count , maxCount);
                }
            }
        }
        return maxCount;
    }

}