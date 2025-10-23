class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int arr[] = new int[s.length()];

        for(int i = 0; i < n; i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }


        while(arr.length > 2) {
            int[] next = new int[arr.length - 1];
            for(int i = 0; i < arr.length - 1; i++) {
                next[i] = (arr[i] + arr[i+1]) % 10;
            }
            arr = next;
        }

        return arr[0] == arr[1];




        // int i = 1;
        // int[] result = new int[n];
        // while(i < n) {
        //     int sum = arr[i] + arr[i - 1];
        //     result[i] = sum % 10;
            
        //     i++;
        // }

        // if(result[0] == result[1]) {
        //     return true;
        // }

        // return false;
    }
}