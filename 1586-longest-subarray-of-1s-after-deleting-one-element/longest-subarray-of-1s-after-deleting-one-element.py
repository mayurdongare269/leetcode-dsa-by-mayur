class Solution(object):
    def longestSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        zero_count = 0
        ans = 0

        for r in range(len(nums)):
            if nums[r] == 0:
                zero_count += 1

            while zero_count > 1:  # shrink window until valid
                if nums[l] == 0:
                    zero_count -= 1
                l += 1

            # subtract 1 because we must delete one element
            ans = max(ans, r - l)

        return ans
