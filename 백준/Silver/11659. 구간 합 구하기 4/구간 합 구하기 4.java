import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] sumArr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            // 구간 합을 통하여 계산하도록 배열 생성, 각 배열의 인덱스에 구간 합을 구함
            sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int startIdx = sumArr[Integer.parseInt(st.nextToken()) - 1];
            int endIdx = sumArr[Integer.parseInt(st.nextToken())];
            result = endIdx - startIdx;
            sb.append(result + "\n");
        }
        System.out.print(sb);
    }
}
