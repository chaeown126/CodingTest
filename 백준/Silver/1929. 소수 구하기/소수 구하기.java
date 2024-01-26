import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
        boolean[] primeArr = new boolean[n+1];
        primeArr[1] = true;

        for(long i = 2; i <= n; i++) {
            if(primeArr[(int) i])  continue;
                for(long j = i * i; j <= n; j += i) {
                       primeArr[(int) j] = true;
                }
        }

        for(int i = m; i <= n; i++){
            if(!primeArr[i]) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}