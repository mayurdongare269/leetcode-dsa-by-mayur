class Solution { // ns_1
    public int intersectionSizeTwo(int[][] intervals) {

        // Sort: end increasing, start decreasing
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int p1 = -1, p2 = -1; // last two chosen points
        int count = 0;

        for (int[] in : intervals) {
            int s = in[0], e = in[1];

            boolean hasP2 = (p2 >= s);
            boolean hasP1 = (p1 >= s);

            if (hasP2 && hasP1) {
                // Already covered by 2 points → do nothing
                continue;
            }

            if (hasP2) {
                // Covered by exactly 1 point → add 1 more point
                count++;
                p1 = p2;
                p2 = e; // choose e (latest usable)
            } else {
                // Covered by 0 points → add 2 new points
                count += 2;
                p1 = e - 1;
                p2 = e;
            }
        }

        return count;
    }
}
