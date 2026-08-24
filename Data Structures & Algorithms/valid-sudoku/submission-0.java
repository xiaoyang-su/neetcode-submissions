class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < 27; i++) {
            map.put(i, new HashSet<>());
        }
        int t = 0;
        for (int i = 0; i < 9; i++) {
            if (t == 1) {
                break;
            }
            for (int j = 0; j < 9; j++) {
                int r = (i / 3) * 3 + j / 3;
                if (map.get(i) != null && map.get(i).contains(board[i][j]) && board[i][j] != '.') {
                    t = 1;
                    break;
                }
                else {
                    map.get(i).add(board[i][j]);
                }
                if (map.get(i) != null && map.get(9 + j).contains(board[i][j]) && board[i][j] != '.') {
                    t = 1;
                    break;
                }
                else {
                    map.get(9 + j).add(board[i][j]);
                }
                if (map.get(i) != null && map.get(18 + r).contains(board[i][j]) && board[i][j] != '.') {
                    t = 1;
                    break;
                }
                else {
                    map.get(18 + r).add(board[i][j]);
                }
            }
        }
        return t != 1;
    }
}