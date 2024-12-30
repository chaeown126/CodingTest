import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int dungChi[][] = new int[n][2];
        int rank[] = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dungChi[i][0] = Integer.parseInt(st.nextToken());
            dungChi[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            int count = 1;
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    if(dungChi[i][0] < dungChi[j][0] && dungChi[i][1] < dungChi[j][1]) {
                        count ++;
                    }
                }
            }
            sb.append(count).append(" ");
        }
        System.out.print(sb);
    }
}