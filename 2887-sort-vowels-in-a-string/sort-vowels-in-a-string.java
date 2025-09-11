// done ... balle balleee
class Solution {
    public String sortVowels(String s) {
        //  1: Extract vowels into a list
        List<Character> vowels = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        Collections.sort(vowels);

        //3: Replace vowels in original string
        StringBuilder result = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                result.setCharAt(i, vowels.get(j++));
            }
        }

        return result.toString();
    }

    // Helper function to check vowel
    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}
