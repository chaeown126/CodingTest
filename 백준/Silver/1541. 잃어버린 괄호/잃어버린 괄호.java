import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String calArr[] = br.readLine().split("-"); // - 연산은 제외하고 +를 먼저 함
        br.close();

        for(int i = 0; i < calArr.length; i++) {
            if(calArr[i].indexOf("+") > 0) { // 요소 중 + 연산 존재 시
                int num = 0;
                String addArr[] = calArr[i].split("\\+"); // + 가 정규식이 아닌 문자로 인식하도록 함
                for(String addNum : addArr) {
                    num += Integer.parseInt(addNum);
                }
                calArr[i] = Integer.toString(num);
            }
        }

        int resultMin = Integer.parseInt(calArr[0]); // 초기값 세팅
        for(int i = 1; i < calArr.length; i++) {
            resultMin -= Integer.parseInt(calArr[i]);
        }

        sb.append(resultMin);
        System.out.print(sb);
    }
}