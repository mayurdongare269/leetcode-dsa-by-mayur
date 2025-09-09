import java.util.*; // done but incompletely \U0001f643

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of characters
        int[] freq = new int[123]; // ASCII range for a-z, A-Z, 0-9
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        // Step 2: Create list of pairs (char, freq)
        List<int[]> vec = new ArrayList<>();
        for (int i = 0; i < 123; i++) {
            if (freq[i] > 0) {
                vec.add(new int[]{i, freq[i]});
            }
        }

        // Step 3: Sort by frequency in descending order
        vec.sort((a, b) -> b[1] - a[1]);

        // Step 4: Build the result string
        StringBuilder result = new StringBuilder();
        for (int[] pair : vec) {
            char ch = (char) pair[0];
            int count = pair[1];
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
