/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            // Generate a number in range [1, 49] using two rand7() calls
            int row = rand7() - 1; // Generates numbers from 0 to 6
            int col = rand7();     // Generates numbers from 1 to 7
            int num = row * 7 + col; // Generates a number from 1 to 49
            
            // Use only numbers 1 to 40 to ensure equal probability for 1-10
            if (num <= 40) {
                return (num % 10) + 1;
            }
        }
    }
}