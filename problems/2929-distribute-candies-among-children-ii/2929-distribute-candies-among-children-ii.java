class Solution {
    public long distributeCandies(int n, int limit) {
        return H3(n)
             - 3 * H3(n - limit - 1)
             + 3 * H3(n - 2 * (limit + 1))
             - H3(n - 3 * (limit + 1));
    }

    private long H3(int n) {
        if (n < 0) return 0;
        return (long)(n + 2) * (n + 1) / 2;
    }
}