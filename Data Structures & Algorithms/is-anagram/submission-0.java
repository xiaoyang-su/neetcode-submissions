class Solution {
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl != tl)
        {
            return false;
        }
        else
        {
        int[] c = new int[sl];
        int[] d = new int[tl];
        for (int i = 0; i < sl; i ++)
        {
            c[i] = s.charAt(i) - 'a';
            d[i] = t.charAt(i) - 'a';
        }
        Arrays.sort(c);
        Arrays.sort(d);
        int j = 0;
        for (int i = 0; i < sl; i ++)
        {
            if (c[i] != d[i])
            {
                j = 1;
                break;
            }
        }
        if (j == 1)
        {
            return false;
        }
        else
        {
            return true;
        }
        }
    }
}