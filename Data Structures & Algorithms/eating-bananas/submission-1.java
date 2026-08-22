class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int left = 1;
int right = 0;

for (int pile : piles) {
    right = Math.max(right, pile);
}

while (left <= right) {
    int mid = left + (right - left) / 2;

    int hours = 0;

    for (int pile : piles) {
        hours += (pile + mid - 1) / mid; // ceiling division
    }

    if (hours <= h) {
        // mid works, try a smaller speed
        right = mid - 1;
    } else {
        // too slow, need to eat faster
        left = mid + 1;
    }
}

return left;
    }

}