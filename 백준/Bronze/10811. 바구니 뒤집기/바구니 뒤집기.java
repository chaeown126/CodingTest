import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 바구니 개수
        int m = Integer.parseInt(st.nextToken()); // 역순하는 횟수
        int x = 0, y = 0; // 바구니 범위(x,y) 공 번호(z)

        ArrayList<Integer> basketArr = new ArrayList<>(){
            {for(int i = 1; i <= n; i++){
                    add(i);
            }}}; // 바구니 개수만큼 생성

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            // x, y 입력
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Stack<Integer> tempStack = new Stack<>();
            int num = x-1;
            for (int j = num; j <= y-1; j++) {
                tempStack.push(basketArr.get(j));
            }

            for (int j = x-1; j <= y-1; j++) {
                basketArr.set(j, tempStack.pop());
            }
        }
        for(Integer result : basketArr){
            bw.write(result + " ");
        }
        bw.flush();
        bw.close();
    }
}