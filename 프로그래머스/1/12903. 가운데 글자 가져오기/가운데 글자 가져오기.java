class Solution {
    public String solution(String s) {
        // 짝수면 몫과 몫+1, 홀수면 몫
        String answer = "";
        if(s.length() % 2 == 0) {
            answer = "" + s.charAt(s.length()/2 - 1) + s.charAt(s.length()/2);
        } else {
            answer = s.charAt(s.length()/2) + "";
        }
        return answer;
    }
}