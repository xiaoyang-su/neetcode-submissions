class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left;
        int a, b;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            left = target - nums[i];
            if (map.containsKey(left))
            {
                a = map.get(left);
                b = i;
                if (a != b)
                {
                    int[] s = new int[2];
                    s[0] = Math.min(a, b);
                    s[1] = Math.max(a, b);
                    return s;
                }
            }
        }
        return nums;
    }
}