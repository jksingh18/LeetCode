class Solution {
    public int countHillValley(int[] nums) {
        // Step 1: Compress consecutive equal elements
        List<Integer> filtered = new ArrayList<>();
        filtered.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { 
                filtered.add(nums[i]);
            }
        }

        int count = 0;
        // Step 2: Check for hills and valleys
        for (int i = 1; i < filtered.size() - 1; i++) {
            int prev = filtered.get(i - 1);
            int curr = filtered.get(i);
            int next = filtered.get(i + 1);

            // Hill: both neighbors smaller
            if (curr > prev && curr > next) {
                count++;
            }
            // Valley: both neighbors larger
            else if (curr < prev && curr < next) {
                count++;
            }
        }
        
        return count;
    }
}