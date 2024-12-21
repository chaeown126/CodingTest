import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        final int ROAD_ARR[] = new int[N-1];
        final int GAS_ARR[] = new int[N];

        // StringTokenizer, split 메모리/시간 비교 필요
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < ROAD_ARR.length; i++) {
            ROAD_ARR[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < GAS_ARR.length; i++) {
            GAS_ARR[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int resultCost = 0; // 출력될 최소 비용
        int i = 0;
        while(i < GAS_ARR.length - 1){
            int num = ROAD_ARR[i]; // 첫 번째 도로 길이 세팅
            int nextIdx = i+1;
            while(GAS_ARR[i] <= GAS_ARR[nextIdx] && nextIdx < ROAD_ARR.length) { // 현재 도시의 주유값이 다음 도시의 주유값보다 싸거나 같으면
                num += ROAD_ARR[nextIdx];   // 다음 도로의 길이를 합함 (싼 비용으로 계산하기 위함)
                nextIdx++;
            }
            resultCost += GAS_ARR[i] * num;
            i = nextIdx;
        }
        sb.append(resultCost);
        System.out.print(sb);
    }
}
