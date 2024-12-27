import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] relation;
    static boolean[] visited;
    static int result = -1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        relation = new ArrayList[n+1]; // 전체 사람 수 (1 ~ n)
        visited = new boolean[n+1]; // 촌수 방문 여부 (1 ~ n)

        for(int i = 1; i <= n; i++) {
            relation[i] = new ArrayList<>();   // 각 배열 내 인접리스트 생성
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            // 그래프 형태이므로 양방향 인접리스트로 구현
            relation[parent].add(child);
            relation[child].add(parent);
        }

        dfs(x, y, 0);   // x로 시작하여 y로 끝남
        sb.append(result);
        System.out.print(sb);

    }

    static void dfs(int start, int end, int cnt) {
        // 촌수 계산이 완료된 경우 result에 최종 값 넣어 마무리
        if(start == end) {
            result = cnt;
            return;
        }
        // 방문하지 않은 경우
        if(!visited[start]) {
            visited[start] = true;  // 방문여부 true
            for(int i = 0; i < relation[start].size(); i++) {   // 인접한 사람(자식)을 통해 반복적으로 탐색
                int prev = relation[start].get(i); 
                dfs(prev, end, cnt+1);  // 자식으로 넘어갈 경우 촌수 + 1
            }
        }
    }
}