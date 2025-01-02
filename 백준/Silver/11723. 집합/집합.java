import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        List<String> list = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            String num = "";
            boolean isContains = false;
            if(!str.equals("all") && !str.equals("empty")){
                num = st.nextToken();
                isContains = list.contains(num);
            }

            switch(str) {
                case "add":
                    if(!isContains)     list.add(num);
                    break;
                case "remove":
                    if(isContains)      list.remove(num);
                    break;
                case "check":
                    if(isContains)      sb.append(1);
                    else                sb.append(0);
                    sb.append("\n");
                    break;
                case "toggle":
                    if(isContains)      list.remove(num);
                    else                list.add(num);
                    break;
                case "all":
                    list.clear();
                    for(int j = 1; j <= 20; j++) {
                        list.add(Integer.toString(j));
                    }
                    break;
                case "empty":
                    list.clear();
                    break;
            }
        }
        System.out.print(sb);
    }
}