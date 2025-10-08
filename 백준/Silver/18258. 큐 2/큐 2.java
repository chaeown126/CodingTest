import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputStr = br.readLine().split(" ");

            switch (inputStr[0]) {
                case "push" :
                    deque.add(Integer.parseInt(inputStr[1]));
                    break;
                case "pop" :
                    if(!deque.isEmpty()) {
                        sb.append(deque.poll());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "size" :
                    sb.append(deque.size());
                    sb.append("\n");
                    break;
                case "empty" :
                    sb.append(deque.isEmpty() ? 1 : 0);
                    sb.append("\n");
                    break;
                case "front" :
                    sb.append(deque.isEmpty() ? -1 : deque.peek());
                    sb.append("\n");
                    break;
                case "back" :
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast());
                    sb.append("\n");

            }
        }

        System.out.print(sb);
    }
}
