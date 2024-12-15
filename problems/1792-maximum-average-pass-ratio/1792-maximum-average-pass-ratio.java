import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max-heap to prioritize classes with the highest marginal gain
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Populate the heap with initial pass ratios and class details
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            // Calculate the current pass ratio and marginal gain of adding one extra student
            double currentRatio = (double) pass / total;
            double gain = calculateGain(pass, total);
            // Add the gain, current pass, and total to the heap
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Distribute the extra students to maximize the average pass ratio
        for (int i = 0; i < extraStudents; i++) {
            // Extract the class with the highest marginal gain
            double[] top = maxHeap.poll();
            double gain = top[0];
            int pass = (int) top[1];
            int total = (int) top[2];

            // Update the class with one extra student
            pass++;
            total++;

            // Recalculate the new marginal gain and push it back into the heap
            double newGain = calculateGain(pass, total);
            maxHeap.offer(new double[]{newGain, pass, total});
        }

        // Calculate the final average pass ratio
        double totalAverage = 0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalAverage += (double) pass / total;
        }

        // Return the average pass ratio
        return totalAverage / classes.length;
    }

    // Helper method to calculate the marginal gain of adding one extra student
    private double calculateGain(int pass, int total) {
        double currentRatio = (double) pass / total;
        double newRatio = (double) (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }
}