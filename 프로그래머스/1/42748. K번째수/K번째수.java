import java.util.*;

class Solution {
    static int[] oldArr;
    static ArrayList<Integer> resultArr = new ArrayList<>();
    public int[] solution(int[] array, int[][] commands) {
        oldArr = array;
        
        for(int i = 0; i < commands.length; i++) {
            subInt(i, oldArr, commands);
        }
         
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            answer[i] = resultArr.get(i);
        }
        
        return answer;
    }
    
    private ArrayList<Integer> subInt(int i, int[] oldArr, int[][] commands) {
        for(int j = 0; j < commands.length; j++) {
            ArrayList<Integer> newArr = new ArrayList<>();
            for(int k = commands[j][0]; k <= commands[j][1]; k++) {
                newArr.add(oldArr[k-1]);
            }
            Collections.sort(newArr);
            resultArr.add(newArr.get(commands[j][2]-1));
        }
        
        return resultArr;
    }
    
}


