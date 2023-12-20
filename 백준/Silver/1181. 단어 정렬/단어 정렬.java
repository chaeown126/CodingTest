import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int inputNum = Integer.parseInt(br.readLine());
        ArrayList<String> word = new ArrayList<>(){
            {
                for(int i = 0; i < inputNum; i++) {
                    add(br.readLine());
                }
            }
        };

        word.stream().sorted((w1 ,w2) -> {
            if(w1.length() - w2.length() == 0) {
                return w1.compareTo(w2);
            } else {
                return w1.length() - w2.length();
            }
        }).distinct().forEach(w -> System.out.println(w));
    }
}
