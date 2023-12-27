import java.util.*;
import java.io.*;

public class Main {
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int pokemonIdx = 0;
        Map<Integer, String> pokemonMap1 = new HashMap<>();
        Map<String, Integer> pokemonMap2 = new HashMap<>();
        String pokemon = null;

        for(int i = 1; i <= n; i++) {
            pokemon = br.readLine();
            pokemonMap1.put(i, pokemon);
            pokemonMap2.put(pokemon, i);
        }

        for(int i = 0; i < m; i++) {
            String tempStr = br.readLine();
            if(isInteger(tempStr)){ // 숫자일 경우
                pokemonIdx = Integer.parseInt(tempStr);
                sb.append(pokemonMap1.get(pokemonIdx) + "\n");
            } else { // 문자열일 경우
                sb.append(pokemonMap2.get(tempStr) + "\n");
            }
        }
        System.out.print(sb);
    }
}