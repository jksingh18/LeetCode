/*

High-Level Idea:
1. Instead of answering queries from nums1 directly, we:
2. Precompute the next greater element for every element in nums2 using a monotonic stack in O(n).
3. Store it in a Map<value, NGE> since all elements in nums2 are distinct.
4. For each nums1[i], just do a map.get(nums1[i]) → O(1).
5. So overall: O(n + m)

*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreaterElementMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=nums2.length-1; i>=0; i--){
            int current = nums2[i];

            while(!stack.isEmpty() && stack.peek() <= current){
                stack.pop();
            }

            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            nextGreaterElementMap.put(current, nextGreater);
            stack.push(current);
        }

        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            result[i] = nextGreaterElementMap.get(nums1[i]);
        }

        return result;
    }
}