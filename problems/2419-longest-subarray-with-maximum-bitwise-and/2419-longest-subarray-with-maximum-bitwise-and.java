/*
Step 1: What is the maximum bitwise AND for any subarray?
- The bitwise AND of a subarray is never greater than max(nums), and in fact, 
        the largest possible AND is simply the maximum element in the array.

Proof: Since AND can only "turn off" bits with more numbers, 
        the largest AND is when the current number itself (without other numbers) is max.

- Any subarray with more than one number can only lower the AND or 
        leave it unchanged if all numbers in the segment have all bits set to max.
*/
class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for(int num : nums){
            maxi = Math.max(maxi, num);
        }

        int maxLength = 0;
        int currentLength = 0;
        for(int num : nums){
            if(num == maxi){
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // continious subArray we need to count, so currentLength = 0;
                // reset on non-maxi element
                currentLength = 0; 
            }
            
        }

        return maxLength;
    }
}