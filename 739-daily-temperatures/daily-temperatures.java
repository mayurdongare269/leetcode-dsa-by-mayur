class Solution { // its monotonic stack que... simple one with monotonic stack >>>> wow !! i found one more que of monotonic stack .. simillar que ... next greater elm I and II

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) { //In this problem, you need the index difference (how many days to wait)
                st.pop();
            }

            if(!st.isEmpty()) {
                nge[i] = st.peek() - i; // wait time
            }

            st.push(i);
        }

        return nge;
    }
}