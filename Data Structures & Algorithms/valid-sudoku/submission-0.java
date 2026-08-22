class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> seenRows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> seenCols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> seenBlocks = new HashMap<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                char num = board[row][col];

                if (num == '.') {
                    continue;
                }

                int block = (row / 3) * 3 + (col / 3);

                seenRows.putIfAbsent(row, new HashSet<>());
                seenCols.putIfAbsent(col, new HashSet<>());
                seenBlocks.putIfAbsent(block, new HashSet<>());

                if (seenRows.get(row).contains(num) ||
                    seenCols.get(col).contains(num) ||
                    seenBlocks.get(block).contains(num)) {
                    return false;
                }

                seenRows.get(row).add(num);
                seenCols.get(col).add(num);
                seenBlocks.get(block).add(num);
            }
        }

        return true;
    }
}
