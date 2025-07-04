class Solution { // contest problem - jun 25
    public List<String> partitionString(String s) {
        Set<String> seen = new HashSet<>();
        // int[] lastIdx = new int[26]; // all lowecase
        List<String> result = new ArrayList<>();
        StringBuilder seg = new StringBuilder();

        
        for(int i = 0; i < s.length(); i++) {
            seg.append(s.charAt(i));
            

            if(!seen.contains(seg.toString())) {
                seen.add(seg.toString());
                result.add(seg.toString());
                seg.setLength(0); // reset the segment
            }
        }

        return result;
    }
}