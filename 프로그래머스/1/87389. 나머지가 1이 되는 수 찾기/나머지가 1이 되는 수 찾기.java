import java.util.*;

class Solution {
    public int solution(int n) {
        // 소수 찾고 가장 작은 소수부터 나눴을 때 1이 되는 수를 바로 출력하면 됨
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                int j = 2;
                while (i * j <= n) {
                    isPrime[i * j++] = false;
                }
            }
        }
        
        for (int x = 2; x < isPrime.length; x++) {
            if (isPrime[x]) {
                if (n % x == 1) {
                    return x;
                }
            }
                
        }
        
        return n - 1;
    }
}