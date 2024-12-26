import java.io.*;
import java.util.*;

public class Main {
    static int dp[] = new int[11];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);

        dp[1] = 1; // 1
        dp[2] = 2; // 2, 1+1
        dp[3] = 4; // 3, 1+2, 2+1, 1+1+1

        for(int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            funcSum(n);
            sb.append(dp[n]);
            if(i < T)
                sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int funcSum (int n) {
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = funcSum(n-3) + funcSum(n-2) + funcSum(n-1);
    }
}