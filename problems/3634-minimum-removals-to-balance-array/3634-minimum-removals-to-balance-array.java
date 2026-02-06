class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int maxLength = 1;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            while ((long) nums[j] > (long) k * nums[i]) {
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return nums.length - maxLength;
    }
}