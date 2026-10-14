class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right] && nums[left] < nums[mid]) {
                return nums[left];
            }
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            }
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
            else {
                return Math.min(nums[left], nums[right]);
            }
        }
        return nums[left];
    }
}