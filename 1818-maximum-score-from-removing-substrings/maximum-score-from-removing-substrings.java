class Solution {// code with mik
    private String removeSubstr(String s, String matchStr) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty() && ch == matchStr.charAt(1) && stack.peek() == matchStr.charAt(0)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder r = new StringBuilder();
        for(char ch : stack) {
            r.append(ch);
        }
        return r.toString();
    }

    public int maximumGain(String s, int x, int y) {
        int score = 0;
        int n = s.length();

        // Decide the order of removal: remove higher gain substrings first
        String maxStr = x > y ? "ab" : "ba";
        String minStr = x > y ? "ba" : "ab";

        int maxVal = Math.max(x, y);
        int minVal = Math.min(x, y);

        // First Pass - remove maxStr
        String tempFirst = removeSubstr(s, maxStr);
        int charsRemoved = n - tempFirst.length();
        score += (charsRemoved / 2) * maxVal;

        // Second Pass - remove minStr
        String tempSecond = removeSubstr(tempFirst, minStr);
        charsRemoved = tempFirst.length() - tempSecond.length();
        score += (charsRemoved / 2) * minVal;

        return score;
    }
}