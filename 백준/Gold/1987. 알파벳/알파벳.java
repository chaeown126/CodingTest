import java.io.*;
import java.util.*;

public class Main {
    static int R, C, answer = 0;
    static char[][] board;
    static boolean[] alphabet;
    // 상하좌우 변경 용도
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        alphabet = new boolean[26];
        alphabet[board[0][0] - 'A'] = true;
        backTracking(0, 0, 1);

        sb.append(answer);
        System.out.print(sb);
    }

    private static void backTracking(int x, int y, int count) {
        answer = Math.max(answer, count); // 백트래킹 수행할 때마다 바로 count 갱신!!
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C && (!alphabet[board[nx][ny] - 'A'])) {
                alphabet[board[nx][ny] - 'A'] = true;
                backTracking(nx, ny, count + 1);
                alphabet[board[nx][ny] - 'A'] = false;

            }
        }
    }
}