class Solution { // easy and learnable que .. good one
    // Methond - 1(long)

    private int[] convertNumToArr(int num) {
        String numStr = String.valueOf(num); // convert num to string
        char[] charArr = numStr.toCharArray(); // convert to charArr
        int[] digits = new int[charArr.length];// Create int array for digits

        for(int i = 0; i < charArr.length; i++) {
            digits[i] = Character.getNumericValue(charArr[i]); //Convert char to int
        }

        return digits;
    }

    public int maximum69Number (int num) {
        int[] digits = convertNumToArr(num);

        // Change the first 6 to 9
        for(int i = 0; i < digits.length; i++) {
            if(digits[i] == 6) {
                digits[i] = 9;
                break;
            }
        }

        // Convert array back to number
        StringBuilder sb = new StringBuilder();
        for(int d : digits) {
            sb.append(d);
        }

        return Integer.parseInt(sb.toString());
    }

    // Mathod- 2
    // public int maximum69Number (int num) {
    //     String numStr = String.valueOf(num);
    //     // replace only the first '6' with '9'
    //     String result = numStr.replaceFirst("6", "9");
    //     return Integer.parseInt(result);
    // }
}