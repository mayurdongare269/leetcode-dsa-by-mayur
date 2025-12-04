class Solution { // done >>>>

    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;

        // Ignore all starting L cars bz they never colalide
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }

        // Ignore all ending R cars
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        int collisions = 0;
        // Count all moving cars (L or R) in the middle region
        for (int i = left; i <= right; i++) {
            char c = directions.charAt(i);
            if (c == 'L' || c == 'R') {
                collisions++;
            }
        }

        return collisions;
    }
}
