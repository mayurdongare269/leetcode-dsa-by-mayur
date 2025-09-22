class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];  // since 1 <= nums[i] <= 100
        int maxFreq = 0;
        
        // Count frequency of each number
        for (int num : nums) {
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }
        
        // Count total elements that have frequency == maxFreq
        int result = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                result += f;
            }
        }
        
        return result;
    }
}
