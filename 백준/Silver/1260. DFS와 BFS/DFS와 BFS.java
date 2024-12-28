import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<Integer>[] adj;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        // 인접리스트 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);

        System.out.print(sb);
    }

    static void dfs(int num) {
        if(!visited[num]) {
            visited[num] = true;
            sb.append(num).append(" ");
            for(int next : adj[num]) {
                dfs(next);
            }
        }
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        sb.append(num).append(" ");

        while(!queue.isEmpty()) {
            int curNum = queue.poll();
            for(int next : adj[curNum]) {
                if(!visited[next]) {
                    queue.add(next);
                    sb.append(next).append(" ");
                    visited[next] = true;
                }
            }
        }
    }
}
