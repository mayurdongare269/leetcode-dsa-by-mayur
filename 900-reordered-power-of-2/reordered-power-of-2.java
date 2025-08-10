class Solution {/// paseted

    // Helper to get the digit count signature
    private String digitSignature(int num) {
        char[] count = new char[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return new String(count);
    }

    public boolean reorderedPowerOf2(int n) {
        String sig = digitSignature(n);

        // Check against all powers of 2 up to 2^30
        for (int i = 0; i < 31; i++) {
            if (sig.equals(digitSignature(1 << i))) {
                return true;
            }
        }
        return false;
    }
}
