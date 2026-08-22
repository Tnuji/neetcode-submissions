class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right )/ 2; 
        while(left <= right)
        {
            middle = (left + right)/2;
            if(nums[middle] == target)
            {
                return middle;
            }
            else if(nums[middle] < target)
            {
                left = middle + 1;
            }
            else if(nums[middle] > target)
            {
                right = middle - 1;
            }
        }

        return -1;
    }
}
