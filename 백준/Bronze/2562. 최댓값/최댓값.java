import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] naturalNum = new int[9];
        int max = -1;

        for(int i = 0; i < naturalNum.length; i++) {
            int num = Integer.parseInt(br.readLine());
            naturalNum[i] = num;
            max = Math.max(max, num);
        }
        sb.append(max).append("\n");

        for(int i = 0; i < naturalNum.length; i++) {
            if(naturalNum[i] == max) {
               sb.append(i + 1);
            }
        }
        System.out.print(sb);
    }
}
