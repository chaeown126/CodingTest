import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()), sum = 0, answer = 0;
        int[] atmTime = new int[n];
        String[] minArr = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            atmTime[i] = Integer.parseInt(minArr[i]);
        }
        Arrays.sort(atmTime); //  오름차순 정렬

        for(Integer i : atmTime) {
            sum += i;
            answer += sum;
        }
        sb.append(answer);
        System.out.print(sb);
    }
}
