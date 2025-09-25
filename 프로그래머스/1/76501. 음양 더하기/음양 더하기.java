class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int arrCnt = absolutes.length;
        int answer = 0;
        
        for (int i = 0; i < arrCnt; i++) {
            answer += absolutes[i] * (signs[i] ? 1 : -1);
        }
        
        return answer;
    }
}