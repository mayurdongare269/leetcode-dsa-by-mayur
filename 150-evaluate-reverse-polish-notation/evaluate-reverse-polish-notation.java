class Solution { //imp
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                int result = operate(a, b, token);
                st.push(result);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }

    private int operate(int a, int b, String token) {
        switch(token) {
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
            default : return -1;
        }
    }
}