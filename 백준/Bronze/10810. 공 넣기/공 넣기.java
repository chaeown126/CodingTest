
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 바구니 개수
        int m = Integer.parseInt(st.nextToken()); // 공을 넣는 횟수
        int x = 0, y = 0, z = 0; // 바구니 범위(x,y) 공 번호(z)

        ArrayList<Integer> basketArr = new ArrayList<>(){
            {
                for(int i = 0; i < n; i++){
                    add(0);
                }
            }
        }; // 바구니 개수만큼 생성, 모두 0으로 초기화

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            // x, y, z 입력
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            while(x <= y){
                basketArr.set(x-1, z);
                x++;
            }
        }
        for(Integer result : basketArr){
            bw.write(result + " ");
        }
        bw.flush();
        bw.close();
    }
}
