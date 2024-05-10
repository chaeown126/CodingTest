import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long k;
    static long[] course;
    static boolean isReverse = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        course = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) {
            course[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            k -= course[i];
            if(k < 0) {
                isReverse = false;
                sb.append(i+1);
                break;
            }
        }

        if(isReverse) {
            for(int i = n-1; i >= 0; i--) {
                k -= course[i];
                if(k < 0) {
                    sb.append(i + 1);
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}