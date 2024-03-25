import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(){
        {
            for (int i = 0; i < N; i++) {
                offer(Integer.parseInt(br.readLine()));
            }
        }};

        while(pq.size() > 1) {
            int temp1 = pq.poll();
            int temp2 = pq.poll();

            sum += temp1 + temp2;
            pq.offer(temp1 + temp2);
        }
        
        sb.append(sum);
        System.out.print(sb);
    }
}