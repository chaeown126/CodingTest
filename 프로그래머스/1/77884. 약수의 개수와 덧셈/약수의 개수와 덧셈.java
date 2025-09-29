class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int divisorCnt = 0;
            int divisorSum = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisorCnt++;
                }
            }
            divisorSum += i;
            if(divisorCnt % 2 == 1) {
                divisorSum *= -1;
            }
            answer += divisorSum;
        }
        
        return answer;
    }
}