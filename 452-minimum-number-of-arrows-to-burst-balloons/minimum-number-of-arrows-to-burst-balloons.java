class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // 1. sort by end

        //2. 
        int arrowPos = points[0][1];
        int arrowShot = 1;

        //3.
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= arrowPos) {
                continue;
            }

            // Otherwise, shoot a new arrow
            arrowShot++;
            arrowPos = points[i][1];
        }

        return arrowShot;
    }
}