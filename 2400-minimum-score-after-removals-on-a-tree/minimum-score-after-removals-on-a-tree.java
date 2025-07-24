class Solution {// copy pppp...

    int[] subXor;
    Set<Integer>[] children;
    List<Integer>[] tree;
    int totalXor;
    int ans;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        totalXor = 0;
        for(int v : nums) totalXor ^= v;

        subXor = nums.clone();
        children = new Set[n];
        tree = new List[n];
        for(int i = 0; i < n; ++i) {
            children[i] = new HashSet<>();
            children[i].add(i);
            tree[i] = new ArrayList<>();
        }

        for(int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        dfs1(0, -1);

        ans = Integer.MAX_VALUE;
        int m = edges.length;
        for(int i = 0; i < m; ++i) {
            int a = edges[i][0], b = edges[i][1];
            if(children[a].contains(b)) {
                int tmp = a; a = b; b = tmp;
            }

            for(int j = 0; j < i; ++j) {
                int c = edges[j][0], d = edges[j][1];
                if(children[c].contains(d)) {
                    int tmp = c;
                    c = d;
                    d = tmp;
                }

                int x, y, z;
                if(a != c && children[a].contains(c)) {
                    x = subXor[c];
                    y = subXor[a] ^ subXor[c];
                    z = totalXor ^ subXor[a];
                } else if(a != c && children[c].contains(a)) {
                    x = subXor[a];
                    y = subXor[c] ^ subXor[a];
                    z = totalXor ^ subXor[c];
                } else {
                    x = subXor[a];
                    y = subXor[c];
                    z = totalXor ^ subXor[a] ^ subXor[c];
                }

                int mx = Math.max(x, Math.max(y , z));
                int mn = Math.min(x, Math.min(y, z));
                ans = Math.min(ans, mx - mn);
            }
        }

        return ans;
    }

    private void dfs1(int u, int p) {
        for(int v : tree[u]) if(v != p) {
            dfs1(v, u);
            subXor[u] ^= subXor[v];
            children[u].addAll(children[v]);
        }
    }
}