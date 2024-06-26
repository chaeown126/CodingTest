import java.io.*;

public class Main {
    private static int T, N;
    private static Integer[][] zeroOrOne = new Integer[41][2]; // Integer로 해야 null 체크 가능
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        zeroOrOne[0][0] = 1;
        zeroOrOne[0][1] = 0;
        zeroOrOne[1][0] = 0;
        zeroOrOne[1][1] = 1;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(String.format("%d %d", zeroOrOne[N][0], zeroOrOne[N][1]) + "\n");
        }
        System.out.print(sb);
    }

    public static Integer[] fibonacci(int N) {
        if(zeroOrOne[N][0] == null || zeroOrOne[N][1] == null) {
            zeroOrOne[N][0] = fibonacci(N-1)[0] + fibonacci(N-2)[0];
            zeroOrOne[N][1] = fibonacci(N-1)[1] + fibonacci(N-2)[1];
        }

        return zeroOrOne[N];
    }
}