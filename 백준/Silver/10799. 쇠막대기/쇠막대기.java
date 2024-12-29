import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        String sticks = br.readLine();
        int count = 0;

        for(int i = 0; i < sticks.length(); i++) {
            if(sticks.charAt(i) == ')') { // 레이저 혹은 파이프의 끝
                if(sticks.charAt(i-1) == '(') { // 레이저일 경우
                    stack.pop();
                    count += stack.size();
                } else {    // 파이프의 끝일 경우
                    stack.pop();
                    count ++;
                }
            } else {
                stack.push(sticks.charAt(i));
            }
        }
        sb.append(count);
        System.out.print(sb);
    }
}