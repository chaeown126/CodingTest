
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        double scores[] = new double[Integer.parseInt(st.nextToken())];
        double avg = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scores);
        double maxScore = scores[scores.length-1];
        for(int i = 0; i < scores.length; i++) {
            scores[i] = (scores[i] / maxScore) * 100;
        }

        for(Double d : scores) {
            avg += d;
        }
        sb.append(avg/(scores.length));
        System.out.print(sb);
    }
}
