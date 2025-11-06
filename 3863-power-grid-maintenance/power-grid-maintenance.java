import java.util.*; // not ssslved

public class _3607_Power_Grid_Maintenance {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int c = 5;
        int[][] connections = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] queries = {{1, 3}, {2, 1}, {1, 1}, {2, 2}, {1, 2}};

        System.out.println(Arrays.toString(sol.processQueries(c, connections, queries)));
        // Output: [3, 2, 3]
    }
}

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);

        // 1️⃣ Build DSU graph
        for (int[] e : connections) {
            dsu.union(e[0], e[1]);
        }

        // 2️⃣ Group stations by component
        Map<Integer, TreeSet<Integer>> compMap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            compMap.putIfAbsent(root, new TreeSet<>());
            compMap.get(root).add(i);
        }

        // 3️⃣ Active state of stations
        boolean[] active = new boolean[c + 1];
        Arrays.fill(active, true);

        // 4️⃣ Process queries
        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int root = dsu.find(x);

            if (type == 1) {
                if (active[x]) {
                    result.add(x);
                } else {
                    TreeSet<Integer> set = compMap.get(root);
                    if (set.isEmpty()) result.add(-1);
                    else result.add(set.first());
                }
            } else if (type == 2) {
                if (active[x]) {
                    active[x] = false;
                    compMap.get(root).remove(x);
                }
            }
        }

        // Convert to int[]
        return result.stream().mapToInt(i -> i).toArray();
    }
}

// Union-Find (Disjoint Set Union)
class DSU {
    int[] parent, rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;
        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pb] < rank[pa]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}
