class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        for(int key : freqMap.keySet()){
            minHeap.offer(new int[]{freqMap.get(key), key});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = minHeap.poll()[1];
        }
        return result;
    }
}