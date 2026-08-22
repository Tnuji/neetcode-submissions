class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int target_row = 0;
        int last_col = matrix[0].length - 1;
        while(target_row < matrix.length - 1)
        {
            int temp = target_row + 1;
            if(matrix[temp][0] > target)
            {
                break;
            }
            ++target_row;
        }

        int left = 0;
        int right = last_col;
        int middle = (left + right) / 2;

        while(left <= right)
        {
            middle = (left + right) / 2;
            if(matrix[target_row][middle] == target)
            {
                return true;
            }
            else if (matrix[target_row][middle] < target)
            {
                left = middle + 1;
            }
            else
            {
                right = middle - 1;
            }
        }
        return false;
    }
}
