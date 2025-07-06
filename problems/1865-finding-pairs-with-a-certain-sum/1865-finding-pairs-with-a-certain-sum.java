import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freqMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freqMap = new HashMap<>();

        // Populate the frequency map for nums2
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        // Update the frequency map
        int oldValue = nums2[index];
        int newValue = oldValue + val;
        nums2[index] = newValue;

        freqMap.put(oldValue, freqMap.get(oldValue) - 1);
        if (freqMap.get(oldValue) == 0) {
            freqMap.remove(oldValue);
        }
        freqMap.put(newValue, freqMap.getOrDefault(newValue, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;

        // Iterate through nums1 and calculate the complement
        for (int num : nums1) {
            int complement = tot - num;
            count += freqMap.getOrDefault(complement, 0);
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */