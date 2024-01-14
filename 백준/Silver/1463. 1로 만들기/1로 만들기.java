import java.io.*;

// 다이나믹 프로그래밍
public class Main {
    static int[] D;
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        x = Integer.parseInt(br.readLine());
        D = new int[x+1];

        D[1] = 0;
        for (int i = 2; i <= x; i++) {
            D[i] = D[i - 1] + 1;
            if(i % 2 == 0) D[i] = Math.min(D[i], D[i/2] + 1);
            if(i % 3 == 0) D[i] = Math.min(D[i], D[i/3] + 1);
        }
        sb.append(D[x]);
        System.out.print(sb);
    }
}
