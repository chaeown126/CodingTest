import java.io.*;
import java.util.*;

// 에라토스테네스의 체
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sb.append(primeCount(n, st));
        System.out.print(sb);
    }

    public static int primeCount(int n, StringTokenizer st){
        int count = 0;
        int max = 1000;
        boolean[] primeArr = new boolean[max + 1];
        primeArr[0] = true;
        primeArr[1] = true;

        for(int i = 2; i < Math.sqrt(max); i++) {
            if(primeArr[i]){
                continue;
            }

            for(int j = i * i; j <= max; j = j + i){
                primeArr[j] = true;
            }
        }

        for(int i = 0; i < n; i++){
            if(!primeArr[Integer.parseInt(st.nextToken())]) count++;
        }
        return count;
    }
}