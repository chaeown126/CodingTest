import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> arr = new ArrayList<>();
        int num = 0;

        for(int i = 1; i <= 30; i++){
            arr.add(i);
        }

        for (int i = 0; i < 28; i++){
            num = Integer.parseInt(br.readLine());
            int finalNum = num;
            arr.removeIf(k -> k == finalNum);
        }
        for(Integer result : arr){
            bw.write(String.valueOf(result) + "\n");
//            if(arr.size() != (arr.indexOf(result))+1){
//                bw.write("\n");
//            }
        }
        bw.flush();
        bw.close();
    }
}
