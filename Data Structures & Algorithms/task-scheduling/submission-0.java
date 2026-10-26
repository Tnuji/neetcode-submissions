class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> max= new PriorityQueue<>(Collections.reverseOrder());
        int[] alphabet = new int[26];

        for(char c : tasks)
        {
            ++alphabet[c - 'A'];
        }


        for(int i : alphabet)
        {
            
            if(i > 0) max.add(i);
        }

        int intervals = 0;

        while(!max.isEmpty()){
            List<Integer> used = new ArrayList<>();
            int count = n + 1;

            while(count > 0 && !max.isEmpty())
            {
                int holder = max.poll();

                if(holder > 1)
                {
                    used.add(holder - 1);
                }

                ++intervals;
                --count;
            }

            for(int i : used)
            {
                max.add(i);
            }
            if(max.isEmpty())
            {
                break;
            }
            
            intervals += count;
        }
        return intervals;
        
    }
}
