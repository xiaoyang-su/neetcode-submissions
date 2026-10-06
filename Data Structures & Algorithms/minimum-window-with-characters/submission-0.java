class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if (n < t.length()) {
            return "";
        }
        HashMap<Character, Integer> mapt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        if (s.length() == 1) {
            if (s.equals(t)) {
                return s;
            }
            else
            {
                return "";
            }
        }
        int right = 0, left = 0;

    int minLen = Integer.MAX_VALUE;
    int minLeft = 0;

    while (left < n) {
        int k = 0;

        for (char c : mapt.keySet()) {
            if (mapt.getOrDefault(c, 0) > map.getOrDefault(c, 0)) {
                k = 1;
                break;
            }
        }

        if (k == 1) {
            if (right < n - 1) {
                right++;
                char c = s.charAt(right);
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else {
                break;
            }
        } else {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minLeft = left;
            }

            char c = s.charAt(left);
            map.put(c, map.get(c) - 1);
            left++;
        }
    }

    if (minLen == Integer.MAX_VALUE) {
        return "";
    }

    return s.substring(minLeft, minLeft + minLen);
    }
}
