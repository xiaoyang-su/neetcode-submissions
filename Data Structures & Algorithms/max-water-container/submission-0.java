class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int prod = (j - i) * Math.min(heights[i], heights[j]);
        while (i < j) {
            if (heights[i] <= heights[j]) {
                i ++;
                int prod1 = (j - i) * Math.min(heights[i], heights[j]);
                if (prod < prod1) {
                    prod = prod1;
                }
            }
            else {
                j --;
                int prod1 = (j - i) * Math.min(heights[i], heights[j]);
                if (prod < prod1) {
                    prod = prod1;
                }
            }
        }
        return prod;
    }
}