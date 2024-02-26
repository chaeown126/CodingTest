import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        // 각 i번째에 ArrayList 를 초기화 시킴 !!!
        for(int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        // 여기서 i는 순서에 지장을 주지 않음, 단순히 갯수를 세는 용도이기 때문에 0부터 시작하는거임
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        for(int i = 1; i < n+1; i++) {
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        sb.append(count);
        System.out.print(sb);
    }

    static void DFS(int n) {
        if(visited[n]) {
            return;
        }
        visited[n] = true;
        for(int i : list[n]) {
            if(!visited[i])       DFS(i);
        }
    }
}