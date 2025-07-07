class Solution {
    public int largestRectangleArea(int[] heights) {
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