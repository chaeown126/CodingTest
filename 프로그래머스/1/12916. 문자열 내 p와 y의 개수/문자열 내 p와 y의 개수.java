class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P' || s.charAt(i) == 'p') {
                count++;
            } else if (s.charAt(i) == 'Y' || s.charAt(i) == 'y') {
                count--;
            }
        }
        
        if (count != 0) {
            answer = false;
        }

        return answer;
    }
}