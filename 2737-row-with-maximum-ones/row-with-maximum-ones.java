class Solution {

    

    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int cnt_max = 0;
        int ind = 0; // start with first row by default
        
        for (int i = 0; i < n; i++) {
            int cnt_one = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) cnt_one++;
            }
            if (cnt_one > cnt_max) {
                cnt_max = cnt_one;
                ind = i;
            }
        }
        
        return new int[] {ind, cnt_max};
    }








    // public int lowerBound(int row[], int x) { // here the rows are not sorted hence we cant use lowerbound.. use normal method...
    //     int m = row.length;
    //     int low = 0, high = m - 1;
    //     int ans = m;
        
    //     while(low <= high) {
    //         int mid = low + (high - low) / 2;
            
    //         if(row[mid] >= x) {
    //             ans = mid;
    //             high = mid - 1;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return ans;
    // }


    // public int[] rowAndMaximumOnes(int[][] mat) {
    //     int n = mat.length;
    //     int m = mat[0].length;
        
    //     int cnt_max = 0;
    //     int ind = -1;
        
        
    //     for(int i = 0; i < n; i++) {
    //         int cnt_one = m - lowerBound(mat[i], 1);
    //         if(cnt_one > cnt_max || (cnt_one == cnt_max && i < ind)) {
    //             cnt_max = cnt_one;
    //             ind = i;
    //         }
    //     }
        
    //     return new int[] {ind, cnt_max};
    // }
}