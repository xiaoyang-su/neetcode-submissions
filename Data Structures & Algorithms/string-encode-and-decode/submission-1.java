class Solution {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str + '\0');
        }
        return String.valueOf(stringBuilder);
    }

    public List<String> decode(String str) {
        List<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '\0') {
                stringBuilder.append(str.charAt(i));
            }
            else
            {
                strings.add(String.valueOf(stringBuilder));
                stringBuilder.setLength(0);
            }
        }
        return strings;
    }
}