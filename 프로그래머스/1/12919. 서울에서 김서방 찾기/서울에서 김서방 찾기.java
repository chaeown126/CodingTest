class Solution {
    public StringBuilder solution(String[] seoul) {      
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                return new StringBuilder("김서방은 ").append(i).append("에 있다");
            }
        }
        
        return null;
    }
}