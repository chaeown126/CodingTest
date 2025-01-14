import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int inputArr[] = new int[N];
        int numArr[] = new int[8001];

        int sum = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            inputArr[i] = num;
            sum += num;
        }
        Arrays.sort(inputArr);

        for(int i = 0; i < N; i++) {
            int temp = inputArr[i] + 4000;
            numArr[temp]++;
        }

        int modeNum = -1, modeCount = -1;
        boolean flag = false;
        for(int i = 0; i < numArr.length; i++) {
            if(numArr[i] > modeCount) {
                modeNum = i;
                flag = false;
                modeCount = numArr[i];
            } else if (!flag && numArr[i] == modeCount) {
                modeNum = i;
                flag = true;
            }
        }

        sb.append(Math.round((double)sum/N)).append("\n");
        sb.append(inputArr[N/2]).append("\n");
        sb.append(modeNum - 4000).append("\n");
        sb.append(inputArr[N-1] - inputArr[0]);

        System.out.print(sb);
    }
}