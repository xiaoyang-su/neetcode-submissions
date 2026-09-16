class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int[] water = new int[height.length];
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
            right[height.length - 1 - i] = Math.max(right[height.length - i], height[height.length  - i]);
        }
        if (height.length > 1) {
            left[height.length - 1] = Math.max(left[height.length - 2], height[height.length - 2]);
            right[0] = Math.max(right[1], height[1]);
        }

        for (int i = 0; i < height.length; i++) {
            water[i] = Math.max(Math.min(left[i], right[i]) - height[i], 0);
            sum += water[i];
        }
        return sum;
    }
}