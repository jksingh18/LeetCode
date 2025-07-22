class Solution {
    /*
    Steps
    1. Extract Digits: Using modulus and division, loop through all digits.
    2. Compute digit sum: Add each digit.
    3. Compute digit product: Multiply each digit.
    4. Compute check sum: Sum of digit sum + digit product.
    5. Check divisibility: Return true if n % (digit sum + digit product) == 0.
    */
    public boolean checkDivisibility(int n) {
        int temp = n;
        int digitSum = 0, digitProduct = 1;
        while (temp > 0) {
            int digit = temp % 10;
            digitSum += digit;
            digitProduct *= digit;
            temp /= 10;
        }
        int checkSum = digitSum + digitProduct;
        return n % checkSum == 0;
    }
}