class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] oletter = new int[26];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            oletter[s1.charAt(i) - 'a']++;
        }
        if (n > s2.length()) {
            return false;
        }
        else {
            int[] letter = new int[26];
            for (int i = 0; i < n; i++) {
                letter[s2.charAt(i) - 'a']++;
            }
            while (right <= s2.length() - 1) {
                boolean key = true;
                int l = 0;
                for (int i = 0; i < 26; i++) {
                    if (letter[i] != oletter[i]) {
                        key = false;
                        break;
                    }
//                    key = false;
                }
                if (key) {
                    return true;
                }
                if (right < s2.length() - 1) {
                    right++;
                    letter[s2.charAt(right) - 'a']++;
                    letter[s2.charAt(left) - 'a']--;
                    left++;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }
}