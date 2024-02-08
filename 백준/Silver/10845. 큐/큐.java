import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int lastNum = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queueFunc(queue, st);
        }
        System.out.print(sb);
    }

    public static void queueFunc(Queue queue, StringTokenizer st){
        int result = 0;
        switch(st.nextToken()) {
            case "push":
                lastNum = Integer.parseInt(st.nextToken());
                queue.offer(lastNum);
                break;
            case "pop":
                if(queue.size() > 0){
                    result = (int) queue.poll();
                } else {
                    result = -1;
                }
                sb.append(result).append("\n");
                break;
            case "front":
                if(queue.size() > 0)    result = (int) queue.peek();
                else                    result = -1;
                sb.append(result).append("\n");
                break;
            case "back":
                if(queue.size() > 0)    result = lastNum;
                else                    result = -1;
                sb.append(result).append("\n");
                break;
            case "empty":
                if(queue.isEmpty())     result = 1;
                else                    result = 0;
                sb.append(result).append("\n");
                break;
            case "size":
                result = queue.size();
                sb.append(result).append("\n");
                break;
            default:
                break;
        }
    }
}