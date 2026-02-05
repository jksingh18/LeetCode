class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];

        for(int i = 0; i < n; i++) {
            int shift = nums[i] % n; //normalizing larger values
            int newIndex = (i + shift) % n;
            if(newIndex < 0) newIndex += n;
            result[i] = nums[newIndex];
        }

        return result;
    }
}