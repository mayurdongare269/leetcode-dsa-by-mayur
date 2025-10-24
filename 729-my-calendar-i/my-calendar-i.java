class MyCalendar {
    List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] interval : bookings) {
            int s1 = interval[0];
            int e1 = interval[1];
            int s2 = startTime;
            int e2 = endTime;

            if(s1 < e2 && s2 < e1) { // overlap condition
                return false;
            }
        }

        // no overlap 
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */