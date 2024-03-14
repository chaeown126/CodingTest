import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] timeArr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int count = 0, prevEndTime = 0;
        N = Integer.parseInt(st.nextToken());
        timeArr = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timeArr[i][0] = Integer.parseInt(st.nextToken());
            timeArr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(timeArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        for(int i = 0; i < N; i++) {
            if(prevEndTime <= timeArr[i][0]) {
                count++;
                prevEndTime = timeArr[i][1];
            }
        }
        
        sb.append(count);
        System.out.print(sb);
    }
}