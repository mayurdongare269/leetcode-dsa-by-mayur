class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        //1. add intervals before newINterval
        while(i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        //2. merge overlaping intervals
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        ///3. add remaining intervals
        while(i < n) {
            res.add(intervals[i]);
            i++;
        }

        //4 convert to arrr
        return res.toArray(new int[res.size()][]);
    }
}