import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> accLedger = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int num = 0, sum = 0;

        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if(num == 0)     accLedger.pop();
            else             accLedger.push(num);
        }

        for(Integer i : accLedger) {
            sum += i;
        }
        sb.append(sum);
        System.out.print(sb);
    }
}