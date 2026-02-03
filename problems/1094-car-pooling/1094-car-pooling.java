class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        // Locations range from 0 to 1000
        int[] diff = new int[1001];

        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += passengers;
            diff[to]   -= passengers;
        }

        int currentPassengers = 0;

        for (int i = 0; i <= 1000; i++) {
            currentPassengers += diff[i];
            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}

/*

Line Sweep - using Ordered Map - Here DAT is optimal because of fixed constraint

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> events = new TreeMap<>();

        for(int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            events.put(from, events.getOrDefault(from, 0) + passengers);
            events.put(to, events.getOrDefault(to, 0) - passengers);
        }

        int currentPassengers = 0;

        for(int delta : events.values()){
            currentPassengers += delta;
            if(currentPassengers > capacity) {
                return false;
            } 
        }

        return true;
    }
}
*/