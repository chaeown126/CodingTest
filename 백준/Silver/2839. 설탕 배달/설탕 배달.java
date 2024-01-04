import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        while (n > 0) {
            if (n % 5 != 0) {
                n -= 3;
                count++;
            } else {
                n -= 5;
                count++;
            }
        }

        if (n != 0) sb.append("-1");
        else sb.append(count);

        System.out.print(sb);
    }
}
