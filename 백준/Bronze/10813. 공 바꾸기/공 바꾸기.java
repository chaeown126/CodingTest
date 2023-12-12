import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = 0, y = 0;
        ArrayList<Integer> basketArr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            basketArr.add(i, i+1);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int tempX = (int)basketArr.get(y-1);
            int tempY = (int)basketArr.get(x-1);

            basketArr.set(x-1, tempX);
            basketArr.set(y-1, tempY);
        }
        for(Integer result : basketArr){
            bw.write(result + " ");
        }
        bw.flush();
        bw.close();
    }
}