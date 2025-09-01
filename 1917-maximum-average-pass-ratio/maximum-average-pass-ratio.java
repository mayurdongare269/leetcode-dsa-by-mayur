import java.util.*; // copied

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max Heap based on gain
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        // Insert initial classes with their gains
        for (int[] c : classes) {
            int p = c[0], t = c[1];
            double gain = gain(p, t);
            pq.add(new double[]{gain, p, t});
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int p = (int) top[1], t = (int) top[2];
            p++; t++;  // Add one student
            double gain = gain(p, t);
            pq.add(new double[]{gain, p, t});
        }

        // Compute final average
        double sum = 0.0;
        for (double[] c : pq) {
            int p = (int) c[1], t = (int) c[2];
            sum += (double) p / t;
        }

        return sum / classes.length;
    }

    // Gain formula
    private double gain(int p, int t) {
        return ((double)(p + 1) / (t + 1)) - ((double)p / t);
    }
}
