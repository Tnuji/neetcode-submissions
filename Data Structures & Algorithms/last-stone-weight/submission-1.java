class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones)
        {
            maxHeap.add(i);
        }

        while(maxHeap.size() > 1)
        {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x - y == 0)
            {
                continue;
            }
            else
            {
                maxHeap.offer(x - y);
            }
        }
        
        if(maxHeap.isEmpty()) return 0;
        return maxHeap.peek();
    }
}
