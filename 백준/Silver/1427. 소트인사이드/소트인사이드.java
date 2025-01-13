import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] numArr = br.readLine().split("");
        String temp;
        for(int i = 0; i < numArr.length-1; i++) {
            for(int j = 0; j < numArr.length-1-i; j++) {
                if(Integer.parseInt(numArr[j]) < Integer.parseInt(numArr[j+1])) {
                    temp = numArr[j];
                    numArr[j] = numArr[j+1];
                    numArr[j+1] = temp;
                }
            }
        }

        for(String num : numArr) {
            sb.append(num);
        }

        System.out.print(sb);
    }
}