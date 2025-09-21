class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int bigNum = a, smallNum = b;
        if (a < b) {
            bigNum = b;
            smallNum = a;
        }
        
        for (int i = smallNum; i <= bigNum; i++) {
            answer += i;
        }
        return answer;
    }
}