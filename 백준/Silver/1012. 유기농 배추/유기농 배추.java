import java.io.*;
import java.util.*;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int M, N, K;
    static int count;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추 개수
            count = 0;

            field = new int[M][N];
            visited = new boolean[M][N];

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            for(int x = 0; x < M; x++) {
                for(int y = 0; y < N; y++) {
                    if(field[x][y] == 1 && !visited[x][y]){
                        dfs(x, y);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if((nx > -1 && nx < M && ny > -1 && ny < N) && field[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}