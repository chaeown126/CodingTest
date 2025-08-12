import java.io.*;
import java.util.*;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int a = -1, b = -1;

        while(true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a != 0 && b != 0)
                sb.append(a+b).append("\n");
            else
                break;
        }
        System.out.print(sb);
    }
}