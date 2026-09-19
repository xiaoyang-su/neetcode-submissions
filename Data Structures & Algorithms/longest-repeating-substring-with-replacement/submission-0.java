class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, ans = 0;
        int[] count = new int[26];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            int maxFreq = 0;
            for (int i : count) {
                maxFreq = Math.max(i, maxFreq);
            }
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
                maxFreq = 0;
                for (int freq : count) {
                    maxFreq = Math.max(maxFreq, freq);
                }
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
