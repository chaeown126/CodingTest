import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] cardArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cardArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cardArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int findNum = Integer.parseInt(st.nextToken());
            sb.append(upperBound(cardArr, findNum) - lowerBound(cardArr, findNum)).append(' ');
        }

        System.out.print(sb);
    }

    static int upperBound(int[] arr, int findNum) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + ((right - left) / 2);

            if (findNum < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int lowerBound(int[] arr, int findNum) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + ((right - left) / 2);

            if (findNum <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}