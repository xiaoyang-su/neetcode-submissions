class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        set.add(s.charAt(0));
        right++;
        int max = 1;
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
                max = Math.max(max, right - left);
            }
//            else {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, right -left);
//            }
        }
        return max;
    }
}