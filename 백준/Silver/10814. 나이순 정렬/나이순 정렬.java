import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String temp;

        int N = Integer.parseInt(br.readLine());
        String[][] users = new String[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            users[i][0] = st.nextToken();
            users[i][1] = st.nextToken();
        }

        Arrays.sort(users, new Comparator<String[]>() {
           @Override
           public int compare(String s1[], String s2[]) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
           }
        });

        for(int i = 0; i < N; i++) {
            sb.append(users[i][0]).append(" ").append(users[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}