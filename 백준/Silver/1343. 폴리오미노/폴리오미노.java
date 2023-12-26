import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String board = br.readLine();

        board = board.replaceAll("XXXX", "AAAA");
        board = board.replaceAll("XX", "BB");

        if(board.indexOf("X") > -1) {
            bw.write(-1 + "");
        } else {
            bw.write(board + "");
        }
        bw.flush();
        bw.close();
    }
}
