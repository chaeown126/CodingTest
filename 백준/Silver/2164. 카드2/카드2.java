import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> cardQueue = new LinkedList<>(){{
            for(int i = n; i >= 1; i--) {
                    push(i);
            }
        }};

        while(cardQueue.size() > 1) {
            cardQueue.poll();
            cardQueue.offer(cardQueue.peek());
            cardQueue.poll();
        }
        sb.append(cardQueue.poll());
        System.out.print(sb);
    }
}