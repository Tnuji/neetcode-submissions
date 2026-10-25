
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) ->
            Integer.compare(
                a[0] * a[0] + a[1] * a[1],
                b[0] * b[0] + b[1] * b[1]
            )
        );

        for (int[] point : points) {
            min.offer(point);
        }

        int[][] answers = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] point = min.poll();
            answers[i][0] = point[0];
            answers[i][1] = point[1];
        }

        return answers;
    }
}