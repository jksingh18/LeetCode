class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);    // Sort tasks by difficulty
        Arrays.sort(workers);  // Sort workers by strength

        int left = 0, right = Math.min(tasks.length, workers.length);

        while (left < right) {
            int mid = (left + right + 1) / 2;  // Try to assign mid tasks

            // Get the strongest mid workers into a TreeMap
            TreeMap<Integer, Integer> avail = new TreeMap<>();
            for (int i = workers.length - mid; i < workers.length; ++i) {
                avail.put(workers[i], avail.getOrDefault(workers[i], 0) + 1);
            }

            boolean canAssign = true;
            int usedPills = 0;

            // Try assigning the hardest mid tasks
            for (int i = mid - 1; i >= 0; --i) {
                int task = tasks[i];

                // Try using the strongest available worker
                if (avail.lastKey() >= task) {
                    decrement(avail, avail.lastKey());
                }
                // Try boosting a weaker worker with a pill
                else {
                    Integer key = avail.ceilingKey(task - strength);
                    if (key == null || ++usedPills > pills) {
                        canAssign = false;
                        break;
                    }
                    decrement(avail, key);
                }
            }

            if (canAssign) left = mid;  // Can try assigning more
            else right = mid - 1;       // Try assigning fewer
        }

        return left;
    }

    // Helper to decrease or remove worker from TreeMap
    private void decrement(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) map.remove(key);
        else map.put(key, count - 1);
    }
}