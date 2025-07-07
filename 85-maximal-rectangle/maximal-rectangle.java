class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] psum = new int[n][m];
        int maxArea = 0;

        //build prefix_sum heights col-wise
        for(int j = 0; j < m; j++) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                if(matrix[i][j] == '1') {
                    sum += 1;
                } else {
                    sum = 0;
                }
                psum[i][j] = sum;
            }
        }

        //for each row, apply largestRectangellARea
        for(int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(psum[i]));
        }

        return maxArea;
    }


    // leetcode 84... 
    private int largestRectangleArea(int[] heights) {
        // The rectangle's width = nextSmaller - prevSmaller - 1.
        // The area = height * width
        // nse - next smaller element
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int elm = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                int width = nse - pse - 1;
                int area = heights[elm] * width;

                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        // Process remaining elements in the stack
        while(!st.isEmpty()) {
                int elm = st.pop();
                int nse = n;
                int pse = st.isEmpty() ? -1 : st.peek();

                int width = nse - pse - 1;
                int area = heights[elm] * width;

                maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}