class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> frequencies = new HashMap<>();

        for(int i : nums)
        {
            if(frequencies.containsKey(i))
            {
                frequencies.put(i , frequencies.get(i) + 1);
            }
            else{
                frequencies.put(i , 1);
            }
        }

        PriorityQueue<int[]> most = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        
        for(Map.Entry<Integer, Integer> entry : frequencies.entrySet())
        {
            most.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] answer = new int[k];

        for(int i = 0; i < k; ++i)
        {
            answer[i] = most.poll()[0];
        }

        return answer;
    }
}
