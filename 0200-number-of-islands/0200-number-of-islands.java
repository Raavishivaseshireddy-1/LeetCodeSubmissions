class Solution {
    class Pair {
        public int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private void bfs(Pair node, char[][] grid, boolean[][] vis) {
        Queue<Pair> queue = new LinkedList<Pair>();
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int n = grid.length, m = grid[0].length;
        vis[node.first][node.second] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            Pair node1 = queue.remove();

            for (int[] d : dir) {
                int row = node1.first + d[0];
                int col = node1.second + d[1];

                if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == '1' && !vis[row][col]) {
                    vis[row][col] = true;
                    queue.add(new Pair(row, col));
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
                    Pair node = new Pair(row, col);
                    bfs(node, grid, vis);
                }
            }
        }

        return count;
    }
}