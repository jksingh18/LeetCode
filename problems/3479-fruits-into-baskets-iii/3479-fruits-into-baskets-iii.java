class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;

        // Find power of two >= n for complete binary tree
        int N = 1;
        while (N < n) N <<= 1;

        // Build storage for segment tree, size 2*N
        int[] segTree = new int[2 * N];

        // Initialize leaves
        for (int i = 0; i < n; i++) {
            segTree[N + i] = baskets[i];
        }
        for (int i = n; i < N; i++) {
            segTree[N + i] = -1; // Mark unused leaves beyond basket length as invalid
        }

        // Build internal nodes bottom-up
        for (int i = N - 1; i > 0; i--) {
            segTree[i] = Math.max(segTree[2 * i], segTree[2 * i + 1]);
        }

        int countUnplaced = 0;

        for (int fruitQty : fruits) {
            if (segTree[1] < fruitQty) {
                // No basket can accommodate the fruit
                countUnplaced++;
                continue;
            }
            // Query the segment tree for the leftmost basket with capacity >= fruitQty
            int idx = 1; // root index
            while (idx < N) {
                int leftChild = idx * 2;
                int rightChild = idx * 2 + 1;
                if (segTree[leftChild] >= fruitQty) {
                    idx = leftChild;
                } else {
                    idx = rightChild;
                }
            }

            // Mark the basket as used at leaf idx
            segTree[idx] = -1;

            // Move upward to update segment tree parents
            idx >>= 1;
            while (idx > 0) {
                segTree[idx] = Math.max(segTree[2 * idx], segTree[2 * idx + 1]);
                idx >>= 1;
            }
        }
        return countUnplaced;
    }
}