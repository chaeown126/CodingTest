import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[Integer.parseInt(br.readLine())];
        Stack<Integer> seq = new Stack<>();
        int stNum = 1, arrNum = 0;

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 수열(배열)
        }

        while(arrNum < arr.length) {
            if(!seq.isEmpty() && seq.peek() == arr[arrNum]) {
                seq.pop();
                arrNum++;
                sb.append("-");
            } else {
                if(stNum <= arr.length){
                    seq.push(stNum);
                    stNum++;
                    sb.append("+");
                } else {
                    System.out.print("NO");
                    return;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}