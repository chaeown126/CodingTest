import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String text[] = {};
        String newStr = "";

        for(int i = 0; i < num; i++) {
            String str = br.readLine();
            text = str.split(" ");
            for(int j = 0; j < text.length; j++) {
                StringBuffer sb = new StringBuffer(text[j]);
                newStr += sb.reverse().toString() + " ";
            }
            bw.write(newStr + "\n");
            newStr = "";
        }
        bw.flush();
        bw.close();
    }
}
