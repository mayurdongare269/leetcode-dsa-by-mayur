class Solution {
    public String largestGoodInteger(String num) {
        String maxGood = "";
        
        for (int i = 0; i < num.length() - 2; i++) {
            // Check if the 3 consecutive characters are the same
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String candidate = num.substring(i, i + 3);
                if (maxGood.isEmpty() || candidate.compareTo(maxGood) > 0) {
                    maxGood = candidate;
                }
            }
        }
        
        return maxGood;
    }
}
