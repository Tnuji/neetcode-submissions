class Solution {
    public int[] countBits(int n) {
       int[] answer = new int[n + 1];

       for(int i = 0; i < n + 1; ++i)
       {
            answer[i] = ones(i);
       }

       return answer;
    }
    public int ones(int n){
        int count = 0;

        while(n != 0){
            count += (n&1);
            n >>= 1;
        }
        return count;
    }
}
