import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Step 1: Sort intervals by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;         // Count of intervals to remove
        int prevEnd = intervals[0][1];  // End time of the last non-overlapping interval

        for (int i = 1; i < intervals.length; i++) {
            // If overlap (start < previous end), we remove this interval
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                // No overlap, update prevEnd
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
