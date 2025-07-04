class Solution {// copy... see again
    public int[][] kClosest(int[][] points, int k) {
        // Max Heap based on distance from origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove the farthest point
            }
        }

        // Prepare result array
        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }

        return result;
    }

    private int distance(int[] point) {
        // Squared Euclidean distance (no sqrt needed)
        return point[0] * point[0] + point[1] * point[1];
    }
}
