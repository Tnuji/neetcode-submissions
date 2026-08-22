class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; ++i)
        {
            if(target > matrix[i][0] && target > matrix[i][matrix[0].length - 1])
            {
                continue;
            }
            else{
                return binary(matrix[i], target);
            }
        }
        return false;
    }
    public boolean binary (int[] array, int target)
    {
        int left = 0;
        int right = array.length -1 ;
        int middle = (left + right) / 2;

        while(left <= right)
        {
            if(array[middle] == target) return true;
            else if(array[middle] > target)
            {
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
            middle = (left + right)/2;
        }
        return false;
    }
}
