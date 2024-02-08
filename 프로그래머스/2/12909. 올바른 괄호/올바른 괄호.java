import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) throws IOException {
        StringBuilder sb = new StringBuilder();
        Stack<Character> bracketStack = new Stack<>();
        boolean flag = false;
        
        try{
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(')
                    bracketStack.push('(');
                else
                    bracketStack.pop();
            }
            
            if(bracketStack.size() == 0)
                flag = true;
            else
                flag = false;
            
        } catch (Exception e) {
            flag = false;
        } finally {
            return flag;
        }
    }
}