class Solution {
    public String solution(String s) {
        String[] numStrArr = s.split(" ");
        int[] numArr = new int[numStrArr.length];
        for(int i = 0; i < numStrArr.length; i++) {
            numArr[i] = Integer.parseInt(numStrArr[i]);
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < numArr.length; i++) {
            min = Math.min(numArr[i], min);
            max = Math.max(numArr[i], max);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}