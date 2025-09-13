import java.util.*;
import java.io.*;

public class Solution {
    public int solution(int n) throws IOException {
        String numStr = String.valueOf(n);
        int answer = 0;
        
        for(int i = 0; i < numStr.length(); i++) {
            int temp = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            answer += temp;
        }
        
        return answer;
        
    }
}