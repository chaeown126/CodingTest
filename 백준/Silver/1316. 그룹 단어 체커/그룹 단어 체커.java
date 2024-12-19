import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < N; i++) {
            boolean alphabet[] = new boolean[26]; // a-z 수 만큼의 자리
            boolean isGroupWord = true;
            String word = br.readLine(); // a a b a
            int prevIndex = word.charAt(0) - 'a'; // 첫 번째 글자 세팅
            for(int j = 0; j < word.length(); j++) {
                int currIndex = word.charAt(j) - 'a'; // 단어의 글자 추적
                // 처음으로 들어오는 문자이거나, 이전의 문자와 같거나
                if(!alphabet[currIndex] || currIndex == prevIndex) {
                    alphabet[currIndex] = true;
                    prevIndex = currIndex;
                } else {
                    isGroupWord = false;
                    break;
                }
            }
            if(isGroupWord)  count++; // 그룹 단어 카운트 수 +1
        }
        br.close();
        sb.append(count);
        System.out.print(sb);
    }
}