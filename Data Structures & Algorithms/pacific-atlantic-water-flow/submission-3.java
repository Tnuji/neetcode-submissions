class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;


        Queue<int[]> queue = new LinkedList<>();
        addRow(0, queue, cols);
        addCol(0, queue, rows);

        boolean[][] pacific = bfs(queue, rows, cols, heights);
        
        addRow(rows - 1, queue, cols);
        addCol(cols - 1, queue, rows);
        boolean[][] atlantic = bfs(queue, rows, cols, heights);

        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < rows; ++i)
        { 
            for(int j = 0; j < cols; ++j)
            {
                if(pacific[i][j] == true && atlantic[i][j] == true)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    answer.add(temp);
                }
            }
    
        }
        return answer;
        
    }

    public boolean[][] bfs(Queue<int[]> queue, int rows,int cols, int[][] heights){
        boolean[][] visited = new boolean[rows][cols];

        while(!queue.isEmpty())
        {
            int[] curr= queue.poll();
            int row = curr[0];
            int col = curr[1];

            if(visited[row][col] == true) continue;
            visited[row][col] = true;
            int value = heights[row][col];
            if(0 <= row - 1 && heights[row - 1][col] >= value && visited[row - 1][col] == false) queue.add(new int[] {row -1, col});
            if(rows > row + 1 && heights[row + 1][col] >= value && visited[row + 1][col] == false) queue.add(new int[] {row +1, col});
            if(0 <= col - 1 && heights[row][col - 1] >= value && visited[row][col - 1] == false) queue.add(new int[] {row, col - 1});
            if(cols > col + 1&& heights[row][col + 1] >= value && visited[row][col + 1] == false) queue.add(new int[] {row, col +1});
            
        }
        return visited;
    }
    
    public void addRow(int row, Queue<int[]> queue, int cols){
        for(int i = 0; i < cols; ++i)
        {
            int col = i;
            int[] point = {row, col};
            queue.add(point);
        }
    }
    public void addCol(int col, Queue<int[]> queue, int rows){
        for(int i = 0; i < rows; ++i)
        {
            int row = i;
            int[] point = {row, col};
            queue.add(point);
        }
    }

    
}
