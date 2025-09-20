class Solution {
    public long solution(long n) {
        int numArr[] = new int[10];
        String tempStr = "";
        String n_str = String.valueOf(n);
        long answer = 0;
        
        for(int i = 0; i < n_str.length(); i++) {
            int plusNum = Long.toString(n).charAt(i) - '0';
            numArr[plusNum]++;
        }
        
        int idx = 9;
        while(idx >= 0) {
            if(numArr[idx] != 0) {
                numArr[idx] -= 1;
                tempStr += idx;
            } else {
                idx--;
            }
        }
        
        answer = Long.parseLong(tempStr);
        
        return answer;
    }
}