class Solution { // done done done... also do leetcode 57 similar...
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        //1. sort by begininh
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //2. list to store
        List<int[]> merged = new ArrayList<>();

        //3. final logic through iteration
        for(int[] interval : intervals) {
            // case1: non overlapped
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else { // c2: overlapping -> merge it
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        //4. convert list to arr
        return merged.toArray(new int[merged.size()][]);

    }
}