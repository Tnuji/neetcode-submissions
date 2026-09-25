class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        LinkedList<int[]> queue = new LinkedList<>();

          for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty())
        {
            int[] temp = queue.remove();
            int r = temp[0];
            int c = temp[1];

            for(int[] direction : directions)
            {
                int nr = r + direction[0];
                int nc = c + direction[1];

                    if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols) {
                    continue;
                }

                if (grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[nr][nc] = grid[r][c] + 1;

                queue.add(new int[]{nr,nc});
            }
        }
    }
}
