class MyCalendarThree { // not solved yet by own... 

     private TreeMap<Integer, Integer> timeline;
    
    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);

        int active = 0, maxOverlap = 0;
        for (int val : timeline.values()) {
            active += val;
            maxOverlap = Math.max(maxOverlap, active);
        }

        return maxOverlap;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */