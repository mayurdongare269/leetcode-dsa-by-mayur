class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int count = 0;
        int prevEnd = 0;
        for(int i = 0; i < intervals.length; i++) {
            // int start = intervals[i][0];
            int end = intervals[i][1];

            if(i == 0 || end > prevEnd) {
                count++;
                prevEnd = end;
            }
        }

        return count;
    }
}