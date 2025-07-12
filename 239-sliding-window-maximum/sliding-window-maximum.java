class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            // Remove out-of-window elements
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove all smaller elements from the back
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i); // Push current index

            // If window has hit size k, add to result
            if(i >= k - 1) {
                list.add(nums[dq.peekFirst()]);
            }
        }

        //convert list to int arr
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}