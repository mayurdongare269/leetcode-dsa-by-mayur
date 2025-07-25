class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        int sum = 0;
        int maxNeg = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num <= 0) {
                maxNeg = Math.max(maxNeg, num);
            } else if(!set.contains(num)) {
                sum += num;
                set.add(num);
            }
        }

        return sum == 0 ? maxNeg : sum;




        // int n = nums.length;
        // Set<Integer> set = new HashSet<>();

        // int i = 0, j = 0;
        // int currSum = 0;
        // int maxSum = 0;

        // while (j < n) {
        //     while (set.contains(nums[j])) {
        //         set.remove(nums[i]);
        //         currSum -= nums[i];
        //         i++;
        //     }

        //     set.add(nums[j]);
        //     currSum += nums[j];
        //     maxSum = Math.max(currSum, maxSum);
        //     j++;
        // }

        // return maxSum;
    }
}






// class Solution {
//     public int maxSum(int[] nums) {
//         int n = nums.length;
//         Set<Integer> set = new HashSet<>();

//         int i = 0, j = 0;
//         int currSum = 0;
//         int maxSum = 0;

//         while(j < n) {
//             while(set.contains(nums[j])) {
//                 set.remove(nums[i]);
//                 currSum -= nums[i];
//                 i++;
//             }

//             set.add(nums[j]);
//             currSum += nums[j];
//             maxSum = Math.max(currSum, maxSum);
//             j++;


//             // if(!set.contains(nums[j])) {
//             //     set.add(nums[j]);
//             //     currSum += nums[j];
//             //     maxSum = Math.max(currSum, maxSum);
//             //     j++;
//             // } else {
//             //     set.remove(nums[i]);
//             //     currSum -= nums[i];
//             //     i++;
//             // }
//         }

//         return maxSum;




//         // int n = nums.length;
//         // Arrays.sort(nums);

//         // if(nums[n - 1] < 0) return nums[n - 1];

//         // Set<Integer> unique = new HashSet<>();

//         // for(int i = 0; i < n; i++) {
//         //     unique.add(nums[i]);
//         // }

//         // int sum = 0;
//         // for(int i = 0; i < n; i++) {
//         //     if(nums[i] > 0) {
//         //         sum += unique.get(i);
//         //     }
//         // }

//         // return sum;

//     }
// }