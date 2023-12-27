import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
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
            if(49 <= tempStr.charAt(0) && tempStr.charAt(0) <= 57) {
                sb.append(pokemonMap1.get(Integer.parseInt(tempStr)) + "\n");
            } else {
                sb.append(pokemonMap2.get(tempStr) + "\n");
            }
        }
        System.out.print(sb);
    }
}