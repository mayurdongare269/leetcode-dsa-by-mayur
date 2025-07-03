class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> js = new HashSet<>();
        for(char c : jewels.toCharArray()) {
            js.add(c);
        } 

        int count = 0;
        for(char c : stones.toCharArray()) {
            if(js.contains(c)) {
                count++;
            }
        }

        return count;
    }
}