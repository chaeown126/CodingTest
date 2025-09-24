class Solution {
    public boolean solution(int x) {
        String x_str = String.valueOf(x);
        int x_sum = 0;
        boolean answer = true;
        
        for(int i = 0; i < x_str.length(); i++) {
            x_sum += Integer.parseInt(x_str.charAt(i) + "");
        }
        System.out.print(x_sum);
        
        if(x % x_sum != 0)
            answer = false;
        
        return answer;
    }
}