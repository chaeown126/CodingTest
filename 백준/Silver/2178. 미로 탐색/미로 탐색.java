import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int map[][];
    static boolean visited[][];
    // 상하좌우 탐색을 위한 배열 선언
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            String str[] = br.readLine().split("");
            for(int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        bfs(1, 1); // 시작 노드
        sb.append(map[N][M]);
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        // 큐가 완전히 비어있을 때까지 반복
        while(!queue.isEmpty()) {
            int[] curArr = queue.poll();
            int curX = curArr[0], curY = curArr[1];
            // 상하좌우 탐색
            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if((nx > 0 && nx <= N && ny > 0 && ny <= M) && map[nx][ny] > 0 && !visited[nx][ny]) {   // 탐색 가능한 경로이고, 방문하지 않았으며 범위에 벗어나지 않는지 체크
                    queue.add(new int[] {nx, ny}); // 새로운 탐색 경로 추가
                    visited[nx][ny] = true;
                    map[nx][ny] = map[curX][curY] + 1;    // 지나온 경로의 카운트를 세기 위해 +1
                }
            }
        }
    }
}