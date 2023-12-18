import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;

        for (int i = 1; i <= 5; i++) {
            int index = br.readLine().indexOf("FBI");
            if(index > -1) {
                bw.write(i + " ");
                count++;
            }
        }

        if(count == 0)
            bw.write("HE GOT AWAY!");
        bw.flush();
        bw.close();
    }
}