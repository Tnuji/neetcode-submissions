class Solution {
    boolean found = false;
    char[][] global;
    int length;
    int rows;
    int cols;
    String word;
    public boolean exist(char[][] board, String word) {
        global = board;
        length = word.length();
        rows = board.length;
        cols = board[0].length;
        this.word = word;

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                if(global[i][j] == word.charAt(0))
                {
                    if(word.length() == 1) return true;
                   if(dfs(i,j,1)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int row, int col, int have)
    {
        if(have == length) return true;
        char holder = global[row][col];
        global[row][col] = '?';
        if(row + 1 < rows && global[row + 1][col] == word.charAt(have))
        {
            if(dfs(row + 1, col, have + 1)) return true;
        }
        if(row - 1 >= 0 && global[row - 1][col] == word.charAt(have))
        {
            if(dfs(row - 1, col, have + 1)) return true;
        }
        if(col + 1< cols && global[row][col + 1] == word.charAt(have))
        {
            if(dfs(row, col + 1, have + 1)) return true;
        }
        if(col - 1 >= 0 && global[row][col - 1] == word.charAt(have))
        {
            if(dfs(row, col - 1, have + 1)) return true;
        }

        global[row][col] = holder;
        return false;
    }
}
