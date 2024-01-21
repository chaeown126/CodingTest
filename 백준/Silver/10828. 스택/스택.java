import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Stack<Integer> intStack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push":
                    intStack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!intStack.isEmpty())   sb.append(intStack.pop() + "\n");
                    else                      sb.append("-1" + "\n");
                    break;
                case "top":
                    if(!intStack.isEmpty())   sb.append(intStack.peek() + "\n");
                    else                      sb.append("-1" + "\n");
                    break;
                case "size":
                    sb.append(intStack.size() + "\n");
                    break;
                case "empty":
                    if(!intStack.isEmpty())   sb.append("0" + "\n");
                    else                      sb.append("1" + "\n");
                    break;
                default:
                    break;
            }
        }

        System.out.print(sb);
    }
}