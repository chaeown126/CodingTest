import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());   // N개의 동전
        int K = Integer.parseInt(st.nextToken());   // K원
        int coinArr[] = new int[N]; // 0으로 초기화된 배열
        int count = 0; // 동전 개수 카운트

        // 동전 배열 생성
        for(int i = 0; i < N; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int currIdx = N - 1;
        while(K != 0) {
            if(coinArr[currIdx] <= K) {
                count += K / coinArr[currIdx];
                K = K % coinArr[currIdx];
            }
            currIdx--;
        }
        sb.append(count);
        System.out.print(sb);
    }
}