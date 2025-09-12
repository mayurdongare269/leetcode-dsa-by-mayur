

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();  // remove smallest
            }
        }
        
        return pq.peek();  // root = kth largest
    }
}
