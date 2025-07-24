class Solution {
    int timer = 1;
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int[] xor = new int[n];
        int[] inTime = new int[n], outTime = new int[n];
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int totalXor = dfs(0, -1, nums, xor, inTime, outTime, adj);
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            int parentA = (inTime[a] < inTime[b]) ? a : b;
            int childA = (inTime[a] < inTime[b]) ? b : a;
            for (int j = i + 1; j < edges.length; j++) {
                int c = edges[j][0], d = edges[j][1];
                int parentB = (inTime[c] < inTime[d]) ? c : d;
                int childB = (inTime[c] < inTime[d]) ? d : c;
                int compA, compB, compC;
                if (isDescendant(childB, childA, inTime, outTime)) {
                    // B is inside A
                    compC = xor[childB];
                    compA = xor[childA] ^ compC;
                    compB = totalXor ^ xor[childA];
                } else if (isDescendant(childA, childB, inTime, outTime)) {
                    // A is inside B
                    compC = xor[childA];
                    compA = xor[childB] ^ compC;
                    compB = totalXor ^ xor[childB];
                } else {
                    // Independent
                    compA = xor[childA];
                    compC = xor[childB];
                    compB = totalXor ^ compA ^ compC;
                }
                int max = Math.max(compA, Math.max(compB, compC));
                int min = Math.min(compA, Math.min(compB, compC));
                res = Math.min(res, max - min);
            }
        }
        return res;
    }

    private int dfs(int node, int parent, int[] nums, int[] xor, int[] in, int[] out, List<Integer>[] adj) {
        in[node] = timer++;
        xor[node] = nums[node];
        for (int child : adj[node]) {
            if (child == parent) continue;
            xor[node] ^= dfs(child, node, nums, xor, in, out, adj);
        }
        out[node] = timer++;
        return xor[node];
    }

    private boolean isDescendant(int u, int v, int[] in, int[] out) {
        return in[v] < in[u] && out[u] <= out[v];
    }
}
