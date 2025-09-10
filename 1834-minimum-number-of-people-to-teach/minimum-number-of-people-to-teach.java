// understanded but not a whole a code.... ╰(*°▽°*)╯

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length; // number of users

        // Convert each user's languages into a Set for quick lookup
        List<Set<Integer>> userLangs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[i]) {
                set.add(lang);
            }
            userLangs.add(set);
        }

        // Step 1: Find sad users (those who cannot communicate with friends)
        Set<Integer> sadUsers = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1; // convert to 0-based index
            int v = f[1] - 1;

            // Check if u and v share a common language
            boolean canTalk = false;
            for (int lang : userLangs.get(u)) {
                if (userLangs.get(v).contains(lang)) {
                    canTalk = true;
                    break;
                }
            }

            // If not, mark both as sad users
            if (!canTalk) {
                sadUsers.add(u);
                sadUsers.add(v);
            }
        }

        // Step 2: Count max known language among sad users
        int[] languageCount = new int[n + 1];
        int mostKnownLang = 0;

        for (int user : sadUsers) {
            for (int lang : userLangs.get(user)) {
                languageCount[lang]++;
                mostKnownLang = Math.max(mostKnownLang, languageCount[lang]);
            }
        }

        // Step 3: Answer = sad users - those who already know the best language
        return sadUsers.size() - mostKnownLang;
    }
}
