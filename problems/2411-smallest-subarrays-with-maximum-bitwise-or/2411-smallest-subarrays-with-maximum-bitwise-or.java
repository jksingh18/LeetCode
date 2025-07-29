class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] lastPos = new int[32];  // latest position right of i for each bit
        Arrays.fill(lastPos, -1);

        for (int i = n - 1; i >= 0; i--) {
            // For each bit, if set in current number nums[i], update its last seen position
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    lastPos[b] = i;
                }
            }
            // For answer[i], the minimum window needed is up to the furthest lastPos (inclusive)
            int maxReach = i;
            for (int b = 0; b < 32; b++) {
                if (lastPos[b] != -1 && lastPos[b] > maxReach) {
                    maxReach = lastPos[b];
                }
            }
            answer[i] = maxReach - i + 1;  // +1 for length (inclusive)
        }
        return answer;
    }
}