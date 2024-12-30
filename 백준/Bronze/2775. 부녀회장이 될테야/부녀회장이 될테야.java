import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int dp[][] = new int[k+1][n+1];
            for(int x = 1; x <= k; x++) {
                for(int y = 1; y <= n; y++) {
                    dp[x][y] = -1;
                    dp[0][y] = y;
                }
            }
            dp[0][0] = 1;

            sb.append(find(k, n, dp)).append("\n");
        }
        System.out.print(sb);

    }

    static int find(int k, int n, int[][] dp) {
        if(dp[k][n] == -1) {
            dp[k][n] = find(k, n - 1, dp) + find(k - 1, n, dp);
        }

        return dp[k][n];
    }
}