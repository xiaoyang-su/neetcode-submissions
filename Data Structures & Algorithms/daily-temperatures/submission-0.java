class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stack1 = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        int j = 0;
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(temperatures[i]);
                stack1.push(i);
            }
            else
            {
                while (!stack.isEmpty() && temperatures[i] > stack.peek()) {
                    ans[stack1.peek()] = i - stack1.pop();
                    stack.pop();
                }
                stack.push(temperatures[i]);
                stack1.push(i);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            ans[stack1.pop()] = 0;
            stack.pop();
        }
        return ans;
    }
}
