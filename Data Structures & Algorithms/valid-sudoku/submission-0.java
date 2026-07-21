class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                String rowKeyStr = num + " in row " + i;
                String colKeyStr = num + " in col " + j;
                String boxKeyStr = num + " in box " + (i/3) + "-" + (j/3);

                if (!set.add(rowKeyStr) || !set.add(colKeyStr) || !set.add(boxKeyStr)) return false;
            }
        } return true;
    }
}
