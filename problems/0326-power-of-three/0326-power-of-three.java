class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3; // Keep dividing by 3 as long as divisible
        }
        return n == 1;
    }
}