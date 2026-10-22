class KthLargest {

    int k;
    int[] nums;
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for(int i: nums){
             heap.add(i);
        }
    }
    
    public int add(int val) {
        heap.add(val);

        while(heap.size() > k)
        {
            heap.poll();
        }
        int answer = heap.peek();
        return answer;
    }
}
