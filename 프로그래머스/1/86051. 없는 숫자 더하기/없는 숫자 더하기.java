class Solution {
    public int solution(int[] numbers) {
        boolean[] numArr = new boolean[10];
        int answer = 0;
        
        for(int i = 0; i < numbers.length; i++) {
            numArr[numbers[i]] = true;
        }
        
        for(int i = 0; i < numArr.length; i++) {
            if(!numArr[i]) {
                answer += i;        
            }
        }
        
        return answer;
    }
}