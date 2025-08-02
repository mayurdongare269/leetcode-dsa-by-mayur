import java.util.*; //copy 

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int fruit : basket1)
            count.put(fruit, count.getOrDefault(fruit, 0) + 1);

        for (int fruit : basket2)
            count.put(fruit, count.getOrDefault(fruit, 0) - 1);

        List<Integer> excess = new ArrayList<>();
        int minElement = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int fruit = entry.getKey(), freq = entry.getValue();

            // If odd frequency overall, it's impossible
            if (Math.abs(freq) % 2 != 0) return -1;

            minElement = Math.min(minElement, fruit);

            // Only collect excess from one side (positive freq means from basket1)
            for (int i = 0; i < Math.abs(freq) / 2; i++) {
                excess.add(fruit);
            }
        }

        Collections.sort(excess);
        long totalCost = 0;
        int n = excess.size();

        // Only need to do half the swaps (because 2 elements per swap)
        for (int i = 0; i < n / 2; i++) {
            totalCost += Math.min(excess.get(i), 2 * minElement);
        }

        return totalCost;
    }
}
