class Solution {
    public int largestRectangleArea(int[] heights) {
                Stack<int[]> stack = new Stack<>(); // {startIndex, height}
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            int start = i;

            // current bar is smaller, so close previous rectangles
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {

                int[] curr = stack.pop();

                int index = curr[0];
                int height = curr[1];

                maxArea = Math.max(maxArea, height * (i - index));

                // this smaller bar can extend backwards
                start = index;
            }

            stack.push(new int[]{start, heights[i]});
        }


        // remaining bars extend to the end
        while (!stack.isEmpty()) {

            int[] curr = stack.pop();

            int index = curr[0];
            int height = curr[1];

            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}
