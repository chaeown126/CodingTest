import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < N; k++) { // 경유 노드
            for(int i = 0; i < N; i++) { // 출발 노드
                for(int j = 0; j < N; j++) { // 도착 노드
                    if(graph[i][k] == 1 && graph[k][j] == 1) { // 경유 노드가 포함된 경로가 모두 1일 경우
                        graph[i][j] = 1; // 지나갈 수 있는 경로이므로 1로 갱신
                    }
                }
            }
        }

        for(int[] i : graph) {
            for(int j : i) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}