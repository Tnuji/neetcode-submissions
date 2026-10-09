/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        int[][] meetings = new int[intervals.size()][2];

        int i = 0;
        for(Interval j : intervals)
        {
            meetings[i][0] = j.start;
            meetings[i][1] = j.end;
            ++i;
        }

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(i = 0; i < meetings.length; ++i)
        {
            if(!heap.isEmpty() && meetings[i][0] >= heap.peek())
            {
                heap.poll();
            }
            heap.add(meetings[i][1]);
        }

        return heap.size();

    }
}
