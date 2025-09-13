class Solution {
    public int maxFreqSum(String s) {
        int freq[] = new int[26];

        //count freq of each char
        for(int c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        //max vowels and consonents
        int maxVowels = 0;
        int maxConso = 0;
        String vowels ="'aeiou";

        for(int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');

            if(freq[i] > 0) {
                if(vowels.indexOf(ch) != -1) {
                    maxVowels = Math.max(maxVowels, freq[i]);
                } else {
                    maxConso = Math.max(maxConso, freq[i]);
                }
            }
        }

        return maxVowels + maxConso;
    }

    
}