import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1; // 첫 시작
        int n = Integer.parseInt(br.readLine());
        int num = 1;
        while(num < n){
            num += count * 6;
            count++;
        }
        sb.append(count);
        System.out.print(sb);
    }
}