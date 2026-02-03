class MyCalendarThree {

    //maxOverlap simple;
    TreeMap<Integer, Integer> events;

    public MyCalendarThree() {
        events = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);

        int currentBooking = 0;
        int maxBooking = 0;

        for(int delta : events.values()) {
            currentBooking += delta;
            maxBooking = Math.max(maxBooking, currentBooking);
        }

        return maxBooking;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */