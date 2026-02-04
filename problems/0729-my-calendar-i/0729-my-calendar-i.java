class MyCalendar {

    TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {

        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);

        int active = 0;

        for(int delta : events.values()) {
            active += delta;

            if(active >= 2){
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
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */