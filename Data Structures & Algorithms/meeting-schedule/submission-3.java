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
    public boolean canAttendMeetings(List<Interval> intervals) {
        int[][] meetings = new int[intervals.size()][2];

        for(int i =0; i < intervals.size(); ++i)
        {
            meetings[i][0] = intervals.get(i).start;
            meetings[i][1] = intervals.get(i).end;   
        }

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

         for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] < meetings[i - 1][1]) {
                return false;
            }
        }

        return true;
    }
}
