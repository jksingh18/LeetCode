class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;
        int full = numBottles;

        while (full > 0) {
            // Drink all full bottles
            ans += full;
            empty += full;
            full = 0;

            // Try to exchange
            if (empty >= numExchange) {
                empty -= numExchange;
                full = 1; // Received 1 new bottle
                numExchange++; // Increase exchange rate
            } else {
                break; // Can't exchange more
            }
        }
        return ans;
    }
}

/*
Approach
Step 1: Drink all available full bottles, converting them into empty bottles.

Step 2: While you have at least numExchange empty bottles, exchange them for one full bottle, increment numExchange by 1, and drink the new bottle, adding its empty one to your empty bottle count.

Repeat until you can no longer perform an exchange.
*/