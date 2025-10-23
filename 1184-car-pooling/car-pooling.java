class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] changes = new int[1001]; // since max location is 1000
        
        // Mark pickup (+) and drop (-)
        for (int[] trip : trips) {
            int num = trip[0], from = trip[1], to = trip[2];
            changes[from] += num;
            changes[to] -= num;
        }
        
        int currPassengers = 0;
        for (int i = 0; i <= 1000; i++) {
            currPassengers += changes[i];
            if (currPassengers > capacity) return false;
        }
        return true;
    }
}
