import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int result = 0;

        int n = Integer.parseInt(br.readLine());
        int arrA[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA); // 배열 정렬해야 이분 탐색 알고리즘 적용 가능

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            sb.append(binarySearch(arrA, Integer.parseInt(st.nextToken()), 0, n-1)).append("\n");
        }
        System.out.print(sb);
    }

    private static int binarySearch(int[] arrA, int target, int start, int end) {
        if(start > end)    return 0;
        int mid = (start + end) / 2;

        if(arrA[mid] == target) {
            return 1;
        } else if(arrA[mid] < target) {
            return binarySearch(arrA, target, mid + 1, end);
        } else {
            return binarySearch(arrA, target, start, mid - 1);
        }
    }
}