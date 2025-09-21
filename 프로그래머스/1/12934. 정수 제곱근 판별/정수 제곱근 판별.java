class Solution {
    public long solution(long n) {
        if(n == 1) {
            return 4;
        }
        long factor = n/2;
        
        for(long i = 1; i <= factor; i++) {
            if(n/i == i && n % i == 0) {
                System.out.print(i);
                return (i+1)*(i+1);
            }
        }
        
        return -1;
    }
}