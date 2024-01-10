import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> ps = new Stack<>();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            try{
                String samplePS = br.readLine();
                int count = 0;
                while(samplePS.length() > count) {
                        if(samplePS.charAt(count) == '('){
                            ps.push("A");
                        } else {
                            ps.pop();
                        }
                        count++;
                }

                if(ps.empty())   sb.append("YES");
                else             sb.append("NO");
            } catch (EmptyStackException e) {
                sb.append("NO");
            } finally {
                System.out.print(sb + "\n");
                sb.setLength(0);
                ps.clear();
            }
        }
    }
}
