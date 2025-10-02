class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = 0;
        int empty = 0;
        int full = numBottles;
        
        while (full > 0) {
            // Drink the current full bottles
            drank += full;
            empty += full;
            // Exchange empty bottles for new full bottles as much as possible
            full = empty / numExchange;
            empty = empty % numExchange;
        }
        
        return drank;
    }
}

/*
Approach
While you have enough empty bottles to exchange (emptyBottles >= numExchange):

Drink all current full bottles, making them empty.

Exchange as many batches of empty bottles as possible for new full bottles.

Update total drank bottles, new empty bottles, and remaining empty bottles.
*/