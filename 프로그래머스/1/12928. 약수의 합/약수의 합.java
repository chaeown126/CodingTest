class Solution {
    public int solution(int n) {
        int factor = n/2;
        int answer = n;
        
        for(int i = factor; i >= 1; i--) {
            if(n % i == 0) {
                answer += i;        
            }
        }
        
        return answer;
    }
}