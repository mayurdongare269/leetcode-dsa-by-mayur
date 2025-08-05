class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        int n = fruits.length;
        boolean used[] = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            boolean placed = false;

            for(int j = 0; j < n; j++) {
                if(!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }

            if(!placed) {
                count++;
            }
        }
        
        return count;
    }
}