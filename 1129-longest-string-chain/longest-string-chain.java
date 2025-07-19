class Solution {
    public int longestStrChain(String[] words) {
        // Step 1: Sort words by increasing length
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // Step 2: Map to store the longest chain ending with each word
        HashMap<String, Integer> dp = new HashMap<>();
        int maxLen = 1;

        // Step 3: For each word, try removing one character to find possible predecessor
        for (String word : words) {
            int best = 1; // minimum chain length is 1 (the word itself)

            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prev)) {
                    best = Math.max(best, dp.get(prev) + 1);
                }
            }

            dp.put(word, best); // store the best chain length for this word
            maxLen = Math.max(maxLen, best);
        }

        return maxLen;
    }
}
