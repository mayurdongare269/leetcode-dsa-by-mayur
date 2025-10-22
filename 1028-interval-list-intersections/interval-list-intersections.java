class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int n = firstList.length, m = secondList.length;
        
        while (i < n && j < m) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            // If they overlap
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            
            // Move the pointer with smaller end time
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}
