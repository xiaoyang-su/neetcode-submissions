class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' ||
                s.charAt(i) == '[' ||
                s.charAt(i) == '{' ) {
                stack[top++] = s.charAt(i);
            }
            else if (s.charAt(i) == ')') {
                if (top >= 1 && stack[top - 1] == '(') {
                    top--;
                }
                else {
                    return false;
                }
            }else if (s.charAt(i) == ']') {
                if (top >= 1 && stack[top - 1] == '[') {
                    top--;
                }
                else {
                    return false;
                }
            }else if (s.charAt(i) == '}') {
                if (top >= 1 && stack[top - 1] == '{') {
                    top--;
                }
                else {
                    return false;
                }
            }
        }
        if (top == 0) {
            return true;
        }
        return false;
    }
}
