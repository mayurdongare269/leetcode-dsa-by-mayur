class Solution { // monotonic stack problem ... wow !!!
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // int[] nge = new int[n];
        // Stack<Integer> st = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>(); // num -> next greater
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            // Maintain a decreasing stack
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num); // current num is next greater
            }
            stack.push(num);
        }

        // Remaining elements in stack have no greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;      
    }
}