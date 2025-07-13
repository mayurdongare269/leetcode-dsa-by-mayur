import java.util.Stack;

class MinStack {
    private Stack<Long> stack;  // Using Long to prevent integer overflow
    private long min;           // Using Long for consistency

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long)val);
            min = val;
        } else {
            if (val >= min) {
                stack.push((long)val);
            } else {
                // Push modified value (2L*val - min) to handle large numbers
                stack.push(2L * val - min);
                min = val;
            }
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        long popped = stack.pop();
        if (popped < min) {
            // Restore previous min using long to prevent overflow
            min = 2L * min - popped;
        }
    }
    
    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        long top = stack.peek();
        if (top >= min) {
            return (int)top;
        } else {
            // Top is actually the current min
            return (int)min;
        }
    }
    
    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return (int)min;
    }
}

/**
 * Explanation of fixes:
 * 1. Changed stack to store Long instead of Integer to prevent overflow
 * 2. Changed min to be long type
 * 3. Added 'L' suffix to numeric literals in calculations (2L * val)
 * 4. Added proper casting when returning int values
 * 
 * This handles the edge cases with large numbers correctly:
 * - When pushing -2147483648, the calculation won't overflow
 * - When restoring previous min, the calculation stays within bounds
 */