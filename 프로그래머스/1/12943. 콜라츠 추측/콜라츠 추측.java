class Solution {
    public int solution(int num) {
        long longNum = num;
        int cnt = 0;
        
        while(longNum != 1 && cnt <= 500) {
            if(longNum % 2 == 0) {
                longNum = longNum / 2;
            } else {
                longNum = (longNum * 3) + 1;
            }
            System.out.print(longNum + " ");
            cnt++;
        }
        
        if(cnt >= 500) {
            cnt = -1;
        }
        
        return cnt;
    }
}