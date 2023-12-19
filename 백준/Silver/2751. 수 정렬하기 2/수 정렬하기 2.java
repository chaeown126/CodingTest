import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> numArr = new ArrayList<>() {
            {
                for(int i = 0; i < num; i++) {
                    add(i, Integer.parseInt(br.readLine()));
                }
            }
        };

        numArr.stream().sorted().forEach(n -> {
            try {
                bw.write(n + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        bw.flush();
        bw.close();
    }
}