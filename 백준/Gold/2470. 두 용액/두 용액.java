import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] solutions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        solutions = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solutions);

        ArrayList<Integer> answer = findTarget(solutions);
        sb.append(answer.get(0)).append(" ").append(answer.get(1));

        System.out.print(sb);

    }

    private static ArrayList<Integer> findTarget(int[] solutions) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 두 포인터 알고리즘 시작
        int start = 0, end = solutions.length - 1;
        int target = 0, sum = 0, min = 2000000000;
        while(start < end) {
            // sum의 절댓값이 더 작을 경우 result에 넣어야 할듯
            sum = solutions[start] + solutions[end];

            if(sum == 0) { // 0일 경우엔 함수를 종료하고 바로 return 하도록 함
                result.clear();
                result.add(solutions[start]);
                result.add(solutions[end]);
                break;
            }

            if(Math.abs(sum) < min){
                result.clear();
                result.add(solutions[start]);
                result.add(solutions[end]);
                min = Math.abs(Math.min(min, sum));
            }

            if(target > sum)
                start += 1;
            else
                end -= 1;
        }

        return result;
    }
}