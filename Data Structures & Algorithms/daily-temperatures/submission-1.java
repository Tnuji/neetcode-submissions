class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Deque<int[]> tempIndex = new ArrayDeque<>();
        int[] length = new int[temperatures.length];


        for(int i = 0; i < temperatures.length; ++i)
        {
            if(!tempIndex.isEmpty()){
            while(!tempIndex.isEmpty() && temperatures[i] > tempIndex.peek()[0])
            {
                int[] holder = tempIndex.pop();
                length[holder[1]] = i - holder[1];
            }}
            
            tempIndex.push(new int[]{temperatures[i], i});
        }
        return length;
    }
}
