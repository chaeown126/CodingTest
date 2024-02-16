import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] priorities;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int tcCnt = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        int count = 0; // 출력할 index
        boolean flag = false; // while 문 종료 플래그
        
        try{
            for(int i = 0; i < tcCnt; i++) {
                st = new StringTokenizer(br.readLine()); // n, m 입력받음

                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());

                priorities = new int[n];
                st = new StringTokenizer(br.readLine());
                for(int j = 0; st.hasMoreTokens(); j++){ // 큐에 우선순위 삽입
                    int print = Integer.parseInt(st.nextToken());
                    priorities[j] = print;
                    pq.offer(print);
                }

                while(!pq.isEmpty() && !flag){
                    for(int k = 0; k < n; k++){
                        if(priorities[k] == pq.peek()){
                            pq.poll();
                            count++;
                            if(k == m){
                                sb.append(count).append("\n");
                                flag = true;
                                break;
                            }
                        }
                    }
                }
                flag = false;
                count = 0;
                pq.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.print(sb);
        }
    }
}