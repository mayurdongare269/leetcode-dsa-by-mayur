class StockSpanner { // monotonic stack problem ... striver soln

    private Stack<int[]> st;  // Stack of [val, index]
    private int ind;

    public StockSpanner() {
        st = new Stack<>();
        ind = -1;
    }
    
    public int next(int val) {
        ind++;

        while (!st.isEmpty() && st.peek()[0] <= val) {
            st.pop();
        }

        int ans = st.isEmpty() ? ind + 1 : ind - st.peek()[1];

        st.push(new int[]{val, ind});

        return ans;
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */