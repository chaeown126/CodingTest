import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        if((n >= 10) && (n % 5 == 1)) {
            n -= 3*2;
            count = (n/5) + 2;
        } else if ((n >= 10) && (n % 5 == 2)) {
            n -= 3*4;
            count = (n/5) + 4;
        } else if ((n >= 10) && (n % 5 == 4)) {
            n -= 3*3;
            count = (n/5) + 3;
        } else {
            count = ((n%5)%3 == 0 ? (n/5) + (n%5)/3 : -1);
        }

        if(count == -1) {
            count = ((n%3)%5 == 0 ? (n/3) + (n%3)/5 : -1);
        }

        sb.append(count);
        System.out.print(sb);
    }
}
