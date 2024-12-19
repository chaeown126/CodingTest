import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final String N = br.readLine(); // 첫 번째로 시작할 수
        String curNum = N, temp = "-1";
        int count = 0;

        while(!N.equals(temp)) {
            String addArr[] = new String[2];
            if(Integer.parseInt(curNum) >= 10) {
                addArr = curNum.split("");
            } else {
                addArr[0] = "0";
                addArr[1] = curNum;
            }

            int sum = Integer.parseInt(addArr[0]) + Integer.parseInt(addArr[1]);
            if(sum >= 10)   sum = Integer.parseInt(Integer.toString(sum).split("")[1]);
            temp = (addArr[1].equals("0") ? "" : addArr[1]) + "" + sum;
            curNum = temp;
            count++;
        }
        sb.append(count);
        System.out.print(sb);
    }
}