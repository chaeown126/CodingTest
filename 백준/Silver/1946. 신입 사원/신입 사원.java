import java.util.*;
import java.io.*;

public class Main {
    static int T, N;
    static int[][] scoreArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            scoreArr = new int[N][2];
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                scoreArr[j][0] = Integer.parseInt(st.nextToken());
                scoreArr[j][1] = Integer.parseInt(st.nextToken());
            }
            // 1차 점수 기준 내림차순 정렬 + 걸러내기
            sb.append(empSelect(scoreArr)).append("\n");
        }
        System.out.print(sb);
    }

    private static int empSelect(int[][] scoreArr) {
        Arrays.sort(scoreArr, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int count = 1, min = scoreArr[0][1];

        for(int i = 1; i < N; i++) {
            if(scoreArr[i][1] < min) {
                count++;
                min = scoreArr[i][1];
            }
        }
        return count;
    }
}