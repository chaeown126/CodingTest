import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        final int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int max = -1000000;
        int min = 1000000;

        for(int i = 0; i < N; i++) {
            int currentNum = Integer.parseInt(st.nextToken());
            if(max < currentNum)    max = currentNum;
            if(min > currentNum)    min = currentNum;
        }

        sb.append(min).append(" ").append(max);
        System.out.print(sb);
    }
}