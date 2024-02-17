import java.util.*;

class Solution {
    static ArrayList<Integer> permArr = new ArrayList<>();
    public int solution(String numbers) {
        String[] strArr = numbers.split("");
        int[] numberArr = new int[strArr.length];
        int answer = 0;
        
        // 문자열 쪼개기
        for(int i = 0; i < strArr.length; i++) {
            numberArr[i] = Integer.parseInt(strArr[i]);
        }
        
        // 1~n 자릿수로 조합
        for(int r = 1; r <= numberArr.length; r++) {
            permutation(numberArr, new int[r], new boolean[numberArr.length], 0, r);
        }
        
        // 소수 판별
        for(int i = 0; i < permArr.size(); i++) {
            if(isPrime(permArr.get(i))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void permutation(int[] numberArr, int[] out, boolean[] visited, int depth, int r) {
        if(depth == r) {
            int num = 0;
            for(int i : out) {
                num = Integer.parseInt(num + "" + i);
            }
            if(!permArr.contains(num)) permArr.add(num);
            return;
        }
        for(int i = 0; i < numberArr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = numberArr[i];
                permutation(numberArr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isPrime (int number) {
        if (number < 2) return false;
        int cnt = 0;
        
        for(int i = 2; i*i <= number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}

