class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] nums1 = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            nums1[i] *= suffix;
            suffix *= nums[i];
        }

        return nums1;
    }
}