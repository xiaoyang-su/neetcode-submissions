class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        int[][] index = new int[2][heights.length];
        for (int i = 0; i < heights.length; i++) {
            index[0][i] = heights.length;
            index[1][i] = -1;
        }
        for (int i = 0; i < heights.length; i++) {
            if (stack1.isEmpty()) {
                stack1.push(i);
            }
            else
            {
                while (!stack1.isEmpty() && heights[i] < heights[stack1.peek()]) {
                    index[0][stack1.pop()] = i;
                }
                stack1.push(i);
            }
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack2.isEmpty()) {
                stack2.push(i);
            }
            else
            {
                while (!stack2.isEmpty() && heights[i] < heights[stack2.peek()]) {
                    index[1][stack2.pop()] = i;
                }
                stack2.push(i);
            }
        }
        int[] ans = new int[heights.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (index[0][i] - index[1][i] - 1) * heights[i];
        }
        Arrays.sort(ans);
        return ans[heights.length - 1];
    }
}