import java.io.*;
import java.util.*;

public class Main {
    static int dp[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        dp = new int[1001];
        Arrays.fill(dp, -1);

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            tileCount(n);
        }
        sb.append(dp[n]);
        System.out.print(sb);
    }

    static int tileCount(int n) {
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = (tileCount(n-1) + tileCount(n-2)) % 10007;
    }
}