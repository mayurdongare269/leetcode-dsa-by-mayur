class Solution {// *NNN* ....
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // dp[i][j] stores the length of LCS between text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If characters match, take diagonal + 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Else, take max from top or left
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the LCS is in dp[n][m]
        return dp[n][m];
    }
}