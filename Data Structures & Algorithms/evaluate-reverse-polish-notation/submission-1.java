class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") &&!tokens[i].equals("*") &&!tokens[i].equals("/")) {
                stack.push(Integer.parseInt(tokens[i]));
            }
            else if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (tokens[i].equals("-")) {
                stack.push(- stack.pop() + stack.pop());
            }
            else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
        }
        return stack.pop();
    }
}