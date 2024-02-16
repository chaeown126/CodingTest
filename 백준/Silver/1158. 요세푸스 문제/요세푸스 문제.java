import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> josephusQueue = new LinkedList<>();
        int count = 1;

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> answerArr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            josephusQueue.offer(i);
        }

        while(!josephusQueue.isEmpty()) {
            if(count == k){
                answerArr.add(josephusQueue.poll());
                count = 1;
            } else {
                josephusQueue.offer(josephusQueue.poll());
                count++;
            }
        }

        sb.append("<");
        for(int i = 0; i < answerArr.size(); i++) {
            sb.append(answerArr.get(i));
            if(i < (answerArr.size()-1))   sb.append(", ");
        }
        sb.append(">");

        System.out.print(sb);
    }
}