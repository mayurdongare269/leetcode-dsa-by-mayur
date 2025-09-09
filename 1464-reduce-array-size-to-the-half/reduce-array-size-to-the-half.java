//need to work on this ps in future.... not done code 
class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Put frequencies into a max-heap (priority queue)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freqMap.values());
        
        // Step 3: Remove highest frequencies until half array is gone
        int removed = 0, setSize = 0;
        while (removed < n / 2) {
            removed += maxHeap.poll(); // take largest frequency
            setSize++;
        }
        
        return setSize;
    }
}
