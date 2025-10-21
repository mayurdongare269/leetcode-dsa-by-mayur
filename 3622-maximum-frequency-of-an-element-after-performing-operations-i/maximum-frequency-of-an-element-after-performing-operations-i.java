class Solution {

    class Event {
        int x;
        int sign; // +1 for start, -1 for end

        Event(int x, int sign) {
            this.x = x;
            this.sign = sign;
        }
    }


    public int maxFrequency(int[] nums, int k, int numOperations) {
    
        Arrays.sort(nums);
        int n = nums.length;

        List<Event> events = new ArrayList<>();
        Set<Integer> criticalPoints = new HashSet<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // 1. 
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            
            int s = num - k;
            int e = num + k;

            events.add(new Event(s, 1));
            events.add(new Event(e + 1, -1)); // e+1 makes the range [s, e] inclusive

            criticalPoints.add(s);
            criticalPoints.add(e + 1);
            criticalPoints.add(num);
        }

        // 2. Sort events and critical points
        events.sort(Comparator.comparingInt(e -> e.x));

        List<Integer> sortedPoints = new ArrayList<>(criticalPoints);
        Collections.sort(sortedPoints);

        int maxFreqPossible = 1;
        int eventId = 0;
        int overlappingCount = 0;

        // 3. Perform the sweep-line
        for (int x : sortedPoints) {
            while (eventId < events.size() && events.get(eventId).x <= x) {
                overlappingCount += events.get(eventId).sign;
                eventId++;
            }

            int currentPointFreq = freqMap.getOrDefault(x, 0);

            int operationsNeeded = Math.max(0, overlappingCount - currentPointFreq);
            int operationsWeCanUse = Math.min(numOperations, operationsNeeded);

            int currentPossibleFreq = currentPointFreq + operationsWeCanUse;
            
            maxFreqPossible = Math.max(maxFreqPossible, currentPossibleFreq);
        }

        return maxFreqPossible;
    }
}