class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int x : nums) sum += x;

        int rem = (int)(sum % p);
        if (rem == 0) return 0;  // already divisible

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // prefix before start

        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;

            // We want prefix[j] - prefix[i] = rem (mod p)
            int need = (int)((prefix - rem + p) % p);

            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }

            map.put((int)prefix, i);
        }

        return ans == nums.length ? -1 : ans;

        // int rem = sum % p;
        // if(rem == 0) {
        //     return count;
        // } else {
            
        // }
    }
}