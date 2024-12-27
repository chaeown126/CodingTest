import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        int rgbHouses[][] = new int[N+1][3];
        int resultCost = -1;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            rgbHouses[i][0] = Math.min(rgbHouses[i-1][1], rgbHouses[i-1][2]) + R;
            rgbHouses[i][1] = Math.min(rgbHouses[i-1][0], rgbHouses[i-1][2]) + G;
            rgbHouses[i][2] = Math.min(rgbHouses[i-1][0], rgbHouses[i-1][1]) + B;
        }
        resultCost = Math.min(rgbHouses[N][0], Math.min(rgbHouses[N][1], rgbHouses[N][2]));
        sb.append(resultCost);

        System.out.print(sb);
    }
}