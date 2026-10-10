class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, left = 0, right = n - 1;
        while (left != right) {
            int mid = (right + left) / 2;
            if (target < nums[mid]) {
                right = mid;
            }
            else if (target > nums[mid]) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        else {
            return -1;
        }
    }
}
