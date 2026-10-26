class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int i : nums)
        {
            maxHeap.offer(i);
        }

        for(int i = 0; i < k - 1; ++i)
        {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
