class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int count = 0;
        int[] nums1 = new int[nums.length];
        for (int num : nums) {
            product *= num;
            if (num == 0) {
                count ++;
            }
        }
        if (product != 0) {
            for (int i = 0; i < nums.length; i++) {
                nums1[i] = (int) (product / nums[i]);
            }
        }
        else
        {
            if (count >= 2)
            {
                Arrays.fill(nums1, 0);
            }
            else
            {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        nums1[i] = 0;
                    }
                    else
                    {
                        nums1[i] = 1;
                        for (int num : nums) {
                            if (num != 0)
                            {
                                nums1[i] *= num;
                            }
                        }
                    }
                }
            }
        }
        return nums1;
    }
}