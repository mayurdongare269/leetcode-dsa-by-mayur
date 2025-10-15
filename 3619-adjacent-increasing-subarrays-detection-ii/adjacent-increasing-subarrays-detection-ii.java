class Solution {
  // Similar to 3349. Adjacent Increasing Subarrays Detection I
  public int maxIncreasingSubarrays(List<Integer> nums) {
    int ans = 0;
    int increasing = 1;
    int prevIncreasing = 0;

    for (int i = 1; i < nums.size(); ++i) {
      if (nums.get(i) > nums.get(i - 1)) {
        ++increasing;
      } else {
        prevIncreasing = increasing;
        increasing = 1;
      }
      ans = Math.max(ans, increasing / 2);
      ans = Math.max(ans, Math.min(prevIncreasing, increasing));
    }

    return ans;
  }
}





// class Solution { ///sssssssss
//     public int maxIncreasingSubarrays(List<Integer> nums) {
//         int n = nums.size();
//         int left = 1, right = n / 2, ans = 0;

//         while (left <= right) {
//             int mid = (left + right) / 2;
//             if (canFind(nums, mid)) {
//                 ans = mid;        // mid is possible, try to go higher
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;  // too large, go smaller
//             }
//         }

//         return ans;
//     }

//     private boolean canFind(List<Integer> nums, int k) {
//         int streak = 1;
//         for (int i = 1; i < nums.size(); i++) {
//             if (nums.get(i) > nums.get(i - 1)) {
//                 streak++;
//                 if (streak >= 2 * k) return true;
//             } else {
//                 streak = 1;
//             }
//         }
//         return false;
//     }
// }
