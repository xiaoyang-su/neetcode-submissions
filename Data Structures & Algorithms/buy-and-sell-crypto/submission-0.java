class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
//        left[0] = prices[0];
        right[n - 1] = prices[n - 1];
        for (int i = 1; i < n; i++) {
//            if (i >= 1) {
//                left[i] = Math.max(prices[i], left[i - 1]);
//            }
//            if (i <n - 1) {
                right[n - i - 1] = Math.max(prices[n - i - 1], right[n - i]);
//            }
        }
        for (int i = 0; i < n; i++) {
            prices[i] = right[i] - prices[i];
        }
        Arrays.sort(prices);
        return prices[n - 1];
    }
}