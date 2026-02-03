class MyCalendarTwo {

    private TreeMap<Integer, Integer> events;

    public MyCalendarTwo() {
        events = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        
        // Step 1: add the new event optimistically
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);

        int active = 0;

        for(int delta : events.values()) {
            active += delta;

            if(active >= 3){
                events.put(startTime, events.getOrDefault(startTime, 0) - 1);
                if(events.get(startTime) == 0) events.remove(startTime); 
                // removing because it does not need to be an event and 
                // accumulate keys in the map unnecessarily, which can be removed

                events.put(endTime, events.getOrDefault(endTime, 0) + 1);
                if(events.get(endTime) == 0) events.remove(endTime);
                // removing because it does not need to be an event and 
                // accumulate keys in the map unnecessarily, which can be removed

                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */