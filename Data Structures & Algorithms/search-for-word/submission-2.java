class Solution {
    char[][] globalB;
    String wGlobal;
    int row;
    int col;
    public boolean exist(char[][] board, String word) {
        globalB = board;
        wGlobal = word;
        row = board.length;
        col = board[0].length;
        for(int i = 0; i < row; ++i)
        {
            for(int j = 0; j < col; ++j)
            {
                if(board[i][j] == word.charAt(word.length() - 1))
                {
                    boolean found = dfs(i,j,word.length() - 1);
                    if(found) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int rows,int cols,int remaining)
    {
        if(remaining == 0) return true;

        char original = globalB[rows][cols];
        globalB[rows][cols] = '#';

        if(rows - 1 >= 0 && remaining > 0 && globalB[rows - 1][cols] == wGlobal.charAt(remaining - 1)){
           if(dfs(rows - 1, cols, remaining - 1)) return true;
        }
        if(rows + 1 <  row && remaining > 0 && globalB[rows + 1][cols] == wGlobal.charAt(remaining - 1)){
           if(dfs(rows + 1, cols, remaining - 1)) return true;
        }
        if(cols - 1 >= 0 && remaining > 0 && globalB[rows][cols - 1] == wGlobal.charAt(remaining - 1)){
           if(dfs(rows, cols - 1, remaining - 1)) return true;
        }
        if(cols + 1 < col && remaining > 0 && globalB[rows][cols + 1] == wGlobal.charAt(remaining - 1)){
           if(dfs(rows, cols + 1, remaining - 1))return true;
        }
        globalB[rows][cols] = original;
        return false;
    }
}
