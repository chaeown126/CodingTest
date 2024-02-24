import java.io.*;

public class Main {
    static int N;
    static int max = 0;
    static int[] timeArr;
    static int[] priceArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        timeArr = new int[N];
        priceArr = new int[N];

        for(int i = 0; i < N; i++) {
            String strs[] = br.readLine().split(" ");
            timeArr[i] = Integer.parseInt(strs[0]);
            priceArr[i] = Integer.parseInt(strs[1]);
        }
        dfsFunc(0, 0);

        sb.append(max);
        System.out.print(sb);
    }

    private static void dfsFunc(int time, int price) {
        if(time >= N) {
            max = Math.max(max, price);
            return;
        }
        if(time + timeArr[time] <= N)   dfsFunc(time + timeArr[time] , price + priceArr[time]);
        else                            dfsFunc(time + timeArr[time], price);
        dfsFunc(time + 1, price);
    }
}