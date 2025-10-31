class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int num : nums) {
            if(seen.contains(num)) {
                ans.add(num);
            } else {
                seen.add(num);
            }
        }

        return new int[]{ans.get(0), ans.get(1)};
    }
}