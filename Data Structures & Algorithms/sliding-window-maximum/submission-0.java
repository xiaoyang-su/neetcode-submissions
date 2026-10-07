class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int idx = 0;

        for (int r = 0; r < n; r++) {

            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[r]) {
                deque.pollLast();
            }

            deque.offerLast(r);

            int left = r - k + 1;

            if (!deque.isEmpty()
                    && deque.peekFirst() < left) {
                deque.pollFirst();
            }

            if (r >= k - 1) {
                res[idx] = nums[deque.peekFirst()];
                idx++;
            }
        }

        return res;
    }
}