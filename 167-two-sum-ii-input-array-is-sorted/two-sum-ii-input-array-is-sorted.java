class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // Return 1-based indices
                return new int[] { left + 1, right + 1 };
            } 
            else if (sum < target) {
                left++;
            } 
            else {
                right--;
            }
        }
        
        // Problem guarantees a solution exists, so this won't execute
        return new int[] { -1, -1 };
    }
}
