class Solution {
    public int maximumWealth(int[][] accounts) {
            int maxWealth = Integer.MIN_VALUE;
            for(int[] account : accounts){
                    int currWealth = 0;
                    for(int money: account){
                            currWealth += money;
                    }
                    maxWealth = Math.max(currWealth, maxWealth);
            }
            return maxWealth;
    }
}