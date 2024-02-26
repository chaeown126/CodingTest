import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean [][] list;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new boolean[N+1][N+1];
        visited = new boolean[N+1];

           for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u][v] = true;
            list[v][u] = true;
        }

        for(int i = 1; i <= N; i++) {
            if(DFS(i)){
                count++;
            }
        }
        sb.append(count);
        System.out.print(sb);
    }

    private static boolean DFS(int node) {
        if(visited[node])   return false;

        visited[node] = true;
        for(int i = 1; i <= N; i++) {
            if(list[node][i]) {
                DFS(i);
            }
        }

        return true;
    }
}