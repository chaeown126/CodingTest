import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n][n];
        int result = -1;

        for(int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            for(int j = 0; j < str.length; j++) {
                dp[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0] + dp[i][0];
            dp[i][i] = dp[i-1][i-1] + dp[i][i];
        }

        for(int i = 2; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(i != j) {    // i와 j가 같은 경우에 대해서는 이미 연산이 끝났으므로 조건 추가
                    dp[i][j] = Math.max(dp[i-1][j-1] + dp[i][j], dp[i-1][j] + dp[i][j]);
                }
            }
        }

        for(int i = 0; i < dp[n-1].length; i++) {
            result = Math.max(result, dp[n-1][i]);
        }

        sb.append(result);
        System.out.print(sb);

    }
}