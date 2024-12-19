import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        br.close();

        sb.append(cycle(N));
        System.out.print(sb);
    }

    public static int cycle(int num) {
        int cycle = 0;
        int start = num;

        do {
            int x = (start % 10) * 10; // 1의 자리가 10의 자리가 됨
            int y = ((start / 10) + (start % 10)) % 10; // 합계의 1의 자리만 남김
            start = x + y;

            cycle++;
        } while(start != num);

        return cycle;
    }
}