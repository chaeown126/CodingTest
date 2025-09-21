class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p_cnt = 0;
        int y_cnt = 0;
        
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                p_cnt++;
            } else if (s.charAt(i) == 'Y') {
                y_cnt++;
            }
        }
        System.out.println(s);
        System.out.print(p_cnt + " " + y_cnt);
        
        if (p_cnt != y_cnt) {
            answer = false;
        }

        return answer;
    }
}