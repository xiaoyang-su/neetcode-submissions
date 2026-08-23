class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] num1 = new  int[n];
        for (int i = 0; i < n; i++) {
            num1[i] = nums[i];
        }
        Arrays.sort(nums);
        int[] t = new int[n];
        int[] t1 = new int[n];
        int[] t2 = new int[n];
        int index = 0;
        ArrayList<Integer> out = new ArrayList<>();
        if (k == n)
        {
            for (int i = 0; i < n; i++) {
                out.add(nums[i]);
            }
        }
        else
        {
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] != nums[i + 1])
                {
                    if (index != 0)
                    {
                        t[index] = i + 1 - t2[index - 1];
                        t2[index] = i + 1;
                        index++;
                    }
                    else
                    {
                        t[index] = i + 1;
                        t2[index] = i + 1;
                        index++;
                    }
                }
            }
            if (index != 0)
            {
                t[index] = n - t2[index - 1];
                    t2[index] = n;
                index++;
            }
            else
            {
                t[index] = n - 1;
                t2[index] = n - 1;
                index++;
            }
//        t2 = t;
            Arrays.sort(t);
            for (int i = 0; i < n; i++) {
                t1[i] = t[n - 1 - i];
            }
            int l = t1[k - 1];
            if (t2[0] >= l)
            {
                out.add(nums[0]);
            }
            for (int i = 0; i < n - 1; i++) {
                if (l == 0)
                {
                    if (t2[i] != 0)
                    {
                        out.add(nums[t2[i]]);
                    }
                }
                else if (t2[i + 1] - t2[i] >= l)
                {
                    out.add(nums[t2[i]]);
                }
            }
        }
        int[] result = new int[out.size()];
        for (int i = 0; i < out.size(); i++) {
            result[i] = out.get(i);
        }
        return result;
    }
}