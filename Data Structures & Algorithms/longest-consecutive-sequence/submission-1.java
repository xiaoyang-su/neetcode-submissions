class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
//        HashSet<Integer> set1 = new HashSet<>();
        if (nums.length == 0)
        {
            return 0;
        }
        int t = 1;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
//            set1.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            else {
                int t1 = 1;
                while (set.contains(nums[i] + t1)) {
                    t1 ++;
                }
                if (t1 > t)
                {
                    t = t1;
                }
            }
        }
        return t;
    }
}