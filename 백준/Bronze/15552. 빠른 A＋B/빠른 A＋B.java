import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        int a = 0, b = 0;
        
        for(int i = 0; i < num; i++) {
            String line = bf.readLine();
            StringTokenizer st = new StringTokenizer(line);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            bw.write(a+b+"\n");
        }
        bw.flush();
        bw.close();
    }
}