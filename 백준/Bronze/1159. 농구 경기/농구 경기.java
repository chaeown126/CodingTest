import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int playerCount = Integer.parseInt(br.readLine());  // 선수 인원수
        ArrayList<String> playNameArr = new ArrayList<>(){{
            for (int i = 0; i < playerCount; i++) {
                String firstName = br.readLine();
                add(i, firstName);
            }
        }}; // 성 모두 입력받기
        playNameArr.stream().sorted(); // 알파벳 순으로 array 정렬

        Map<String, Integer> playerFirstName = new HashMap<>(); // 성 첫 글자별로 있는 선수 인원수
        for(String str : playNameArr) {
            String currentKey = String.valueOf(str.charAt(0));
            if(playerFirstName.containsKey(currentKey)){
                playerFirstName.replace(currentKey, playerFirstName.get(currentKey)+1);
            } else {
                playerFirstName.put(currentKey, 1);
            }
        }
        if(playerFirstName.entrySet().stream().filter(p -> p.getValue() >= 5).count() > 0) {
            playerFirstName.entrySet().stream().filter(p -> p.getValue() >= 5).forEach(p -> System.out.print(p.getKey()));
        } else {
            System.out.print("PREDAJA");
        }
    }
}