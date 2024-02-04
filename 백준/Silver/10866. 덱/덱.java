import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(!deque.isEmpty())    sb.append(deque.pollFirst());
                    else                    sb.append(-1);
                    sb.append("\n");
                    break;
                case "pop_back":
                    if(!deque.isEmpty())    sb.append(deque.pollLast());
                    else                    sb.append(-1);
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(!deque.isEmpty())    sb.append(0);
                    else                    sb.append(1);
                    sb.append("\n");
                    break;
                case "front":
                    if(!deque.isEmpty())    sb.append(deque.peekFirst());
                    else                    sb.append(-1);
                    sb.append("\n");
                    break;
                case "back":
                    if(!deque.isEmpty())    sb.append(deque.peekLast());
                    else                    sb.append(-1);
                    sb.append("\n");
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}
