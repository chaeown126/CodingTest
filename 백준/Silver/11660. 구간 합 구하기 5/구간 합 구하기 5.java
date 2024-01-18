import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] numArr = new int[n+1][n+1]; // 행 단위 구간합 2차원 배열
        int[][] sumArr = new int[n+1][n+1]; // 행 단위 구간합 2차원 배열
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0, result = 0;

        // numArr 배열 생성
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // sumArr 배열 생성
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sumArr[i][j] = (numArr[i][j] + sumArr[i-1][j] + sumArr[i][j-1]) - sumArr[i-1][j-1];
            }
        }

        // 구간 합을 구할 횟수
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            result = sumArr[x2][y2] - (sumArr[x2][y1-1] + sumArr[x1-1][y2]) + sumArr[x1-1][y1-1];
            sb.append(result + "\n");
        }
        System.out.print(sb);
    }
}