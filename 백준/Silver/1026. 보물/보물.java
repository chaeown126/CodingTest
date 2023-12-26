import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int result = 0;
        List<Integer> listA = new ArrayList<>(){
            {StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i = 0; i < count; i++) {
                    add(i, Integer.parseInt(st.nextToken()));
            }}
        };
        List<Integer> listB = new ArrayList<>(){
            {StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i = 0; i < count; i++) {
                add(i, Integer.parseInt(st.nextToken()));
            }}
        };

        listA = listA.stream().sorted().collect(Collectors.toList()); // 오름차순 정렬
        listB = listB.stream().sorted((n, m) -> {return m-n;}).collect(Collectors.toList()); // 내림차순 정렬

        for(int i = 0; i < count; i++) {
            result += listA.get(i) * listB.get(i);
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}