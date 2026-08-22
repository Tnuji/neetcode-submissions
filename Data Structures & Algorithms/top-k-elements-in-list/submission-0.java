class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for(int i : nums)
        {
            if(!frequencies.containsKey(i))
            {
                frequencies.put(i , 0);
            }
            frequencies.merge(i, 1, Integer::sum);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> frequencies.get(b) - frequencies.get(a));
        maxHeap.addAll(frequencies.keySet());
       /* {
            for(Map.Entry<Integer, Integer> f : frequencies.entrySet())
            {
                maxHeap.addAll(frequencyMap.keySet());
            }
        }*/

        int[] answer = new int[k];
        for(int i = 0; i < k; ++i)
        {
            answer[i] = maxHeap.poll();
        }
        return answer;
    }
}
