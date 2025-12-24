class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int tot = 0;
        int count = 0;
        int sum = 0;

        for(int a : apple) {
            tot += a;
        }

        Arrays.sort(capacity);
        for(int i = capacity.length-1; i >= 0 ; i--) {
            sum += capacity[i];
            count++;
            if(sum >= tot) {
                return count;
            }
        }

        return 0;
    }
}