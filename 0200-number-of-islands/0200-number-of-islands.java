class Solution {
    class Pair {
        public int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private void bfs(int r, int c, char[][] grid, boolean[][] vis) {
        Queue<Pair> queue = new LinkedList<Pair>();
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};
        int n = grid.length, m = grid[0].length;
        vis[r][c] = true;
        queue.add(new Pair(r, c));

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for (int[] d : dir) {
                int nrow = row + d[0];
                int ncol = col + d[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && !vis[row][col]) {
                    count++;
                    bfs(row, col, grid, vis);
                }
            }
        }

        return count;
    }
}