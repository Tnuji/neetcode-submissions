class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        
        stack.push(new int[]{temperatures[0], 0});
        int[] result = new int[temperatures.length];
        for(int i = 1; i < temperatures.length; ++i)
        {
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0])
            {
                int[] calc = stack.pop();
                result[calc[1]] = i - calc[1];
            }
            stack.push(new int[]{temperatures[i] , i});
        }
        return result;
    }
}
