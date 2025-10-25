class Solution {
    public int totalMoney(int n) {

        int weekStart = 1;
        int total = 0;

        while(n > 0) {
            for(int i = 0; i < Math.min(n,7); i++) {
                total += (weekStart + i); // i == day
            }
            weekStart++;
            n-=7;
        }
        return total;





        // int i = 0;
        // int count = 0;
        // int totMoney = 0;
        
        // while(i < n) {
        //     for(int j = 1; j <= 7; j++) {
        //         totMoney++;
        //     }
        //     count++;
        // }
    }
}