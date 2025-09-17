class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int i = 0;
        long plusNum = x;
        
        do {
            answer[i] = plusNum;
            plusNum += x;
            i++;
        } while (i < n);

        return answer;
    }
}