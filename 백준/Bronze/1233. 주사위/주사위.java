import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String arr[] = br.readLine().split(" ");
        int dice1[] = new int[Integer.parseInt(arr[0])];
        int dice2[] = new int[Integer.parseInt(arr[1])];
        int dice3[] = new int[Integer.parseInt(arr[2])];

        for (int i = 0; i < dice1.length; i++) {
            dice1[i] = i + 1;
        }
        for (int i = 0; i < dice2.length; i++) {
            dice2[i] = i + 1;
        }
        for (int i = 0; i < dice3.length; i++) {
            dice3[i] = i + 1;
        }

        int sum[] = new int[81];
        for(int i = 0; i < dice1.length; i++){
            for(int j = 0; j < dice2.length; j++) {
                for(int k = 0; k < dice3.length; k++) {
                    sum[dice1[i] + dice2[j] + dice3[k]]++;
                }
            }
        }

        int key = 0;
        int res = 0;
        for (int i = 0; i < sum.length; i++) {
            key = Math.max(key, sum[i]);
        }
        for (int i = 0; i < sum.length; i++) {
            if (key == sum[i]) {
                res = i;
                break;
            }
        }
        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}