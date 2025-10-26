class Solution {
    public int secondHighest(String s) {
        int firstMax = -1;
        int secMax = -1;

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                int d = ch - '0';

                if(d > firstMax) {
                    secMax = firstMax;
                    firstMax = d;
                } else if(d < firstMax && d > secMax) {
                    secMax = d;
                }
            }
        }

        return secMax;
    }
}