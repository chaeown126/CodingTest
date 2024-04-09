import java.io.*;

public class Main {
    static int N;
    static int count;
    static char[][] art;
    static char[][] artRG;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        art = new char[N+1][N+1];
        artRG = new char[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                art[i][j] = str.charAt(j);
                if(str.charAt(j) == 'G') {
                    artRG[i][j] = 'R';
                } else {
                    artRG[i][j] = str.charAt(j);
                }
            }
        }
        // 적록색약이 아닌 사람이 보는 그림
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                DFS(i ,j, art);

                count++;
            }
        }
        sb.append(count).append(" ");

        // 적록색약인 사람이 보는 그림
        count = 0;
        visited = new boolean[N+1][N+1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                DFS(i ,j, artRG);
                count++;
            }
        }
        sb.append(count);
        System.out.print(sb);
    }

    private static void DFS(int x, int y, char art[][]) {
        if(visited[x][y]) {
            count--;
            return;
        }

        visited[x][y] = true;

        // 상
        if(x > 0 && !visited[x-1][y] && (art[x][y] == art[x-1][y]))
            DFS(x-1, y, art);
        // 하
        if(x < N && !visited[x+1][y] && (art[x][y] == art[x+1][y]))
            DFS(x+1, y, art);
        // 좌
        if(y > 0 && !visited[x][y-1] && (art[x][y] == art[x][y-1]))
            DFS(x, y-1, art);
        // 우
        if(y < N && !visited[x][y+1] && (art[x][y] == art[x][y+1]))
            DFS(x, y+1, art);

    }
}