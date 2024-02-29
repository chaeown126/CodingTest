import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int count;
    static boolean[][] visited;
    static boolean[][] map;
    static ArrayList<Integer> complexArr = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        // 각 배열을 초기화
        visited = new boolean[N+1][N+1];
        map = new boolean[N+1][N+1];

        // map 배열에 지도 정보 입력 (0 : false, 1 : true)
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) == '1' ? true : false;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                count = 0;
                DFS(i, j);
                if(count > 0)   complexArr.add(count);
            }
        }
        sb.append(complexArr.size()).append("\n");
        complexArr.stream().sorted().forEach(x -> sb.append(x).append("\n"));

        System.out.print(sb);
    }

    static void DFS(int x, int y) {
        // 집이 없는 곳이거나, 방문했던 곳이면 false
        if(!map[x][y] || visited[x][y])
            return;

        visited[x][y] = true; // 방문 처리
        count++;
        if(x > 0)   DFS(x-1, y); // 상
        DFS(x+1, y); // 하
        if(y > 0)   DFS(x, y-1); // 좌
        DFS(x, y+1); // 우

    }
}