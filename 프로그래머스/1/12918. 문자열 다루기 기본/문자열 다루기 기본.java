class Solution {
    public boolean solution(String s) {
        int str_len = s.length();
        if(str_len == 4 || str_len == 6) {
            for(int i = 0; i < str_len; i++) {
                if(!(s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                    return false;
                }
            }
        } else {
            return false;
        }
                   
        return true;
    }
}