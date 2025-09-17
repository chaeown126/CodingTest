import java.util.*;

class Solution {
    public int[] solution(long n) {
        String numStr = String.valueOf(n);
        int numLength = numStr.length();
        int answer[] = new int[numLength];
        int j = 0;
        
        for(int i = numLength - 1; i>= 0; i--) {
            j = (i - numLength + 1) * (-1);
            answer[j] = Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }
        
        return answer;
        
    }
}