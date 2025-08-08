class Solution {
    public static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for(int i = 0; i < n; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int noOfDays = findDays(weights, mid);
            if(noOfDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int findDays(int arr[], int cap) {
        int days = 1;
        int n = arr.length;
        int load = 0;

        for(int i = 0; i < n; i++) {
            if(load + arr[i] > cap) {
                days += 1;
                load = arr[i];
            } else {
                load += arr[i];
            }
        }

        return days;
    }


    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = shipWithinDays(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }


}