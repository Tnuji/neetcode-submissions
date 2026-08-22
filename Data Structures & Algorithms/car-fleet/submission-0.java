class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
                // store cars as {position, speed}
        int[][] cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // sort closest to destination first
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();

        for (int[] car : cars) {
            int pos = car[0];
            int spd = car[1];

            // time to reach target
            double time = (double)(target - pos) / spd;

            // if current car takes longer, it becomes a new fleet
            // otherwise it merges with the fleet ahead
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
