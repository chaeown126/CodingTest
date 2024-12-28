
import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<Integer>[] network;
    static boolean visited[];
    static int count;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        network = new ArrayList[V+1];
        visited = new boolean[V+1];

        // 인접리스트 생성
        for(int i = 1; i <= V; i++) {
            network[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향.. 같은데?
            network[x].add(y);
            network[y].add(x);
        }

        dfs(1);
        sb.append(count-1);
        System.out.print(sb);
    }

    static void dfs(int n) {
        if(!visited[n]) {
            visited[n] = true;
            count++;
            for(int i = 0; i < network[n].size(); i++) {
                int next = network[n].get(i);
                dfs(next);
            }
        }
    }
}
