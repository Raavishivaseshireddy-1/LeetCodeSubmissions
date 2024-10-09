class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int counter = 0;
        for(int i = 0; i < vis.length; i++) {
            if(vis[i] == false) {
                counter++;
                dfs(i, adj, vis);
            }
        }
        return counter;
    }
    
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[i] = true;
        for(int it: adj.get(i)) {
            if(vis[it] == false) {
                dfs(it, adj, vis);
            }
        }
    }
}