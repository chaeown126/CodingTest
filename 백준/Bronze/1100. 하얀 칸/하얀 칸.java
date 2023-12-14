import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] chessArr = new String[8][8];
        int count = 0;

        // 배열에 체스 정보 집어넣기
        for(int i = 0; i < chessArr.length; i++){
            String line = br.readLine();
            for(int j = 0; j < chessArr[i].length; j++){
                chessArr[i][j] = String.valueOf(line.charAt(j));
            }
        }
        // i홀수, j홀수 / i짝수, j짝수 일때 말이 있는지 비교
        for(int i = 0; i < chessArr.length; i++){
            for(int j = 0; j < chessArr[i].length; j++){
                if((i%2 == 1 && j%2 == 1) || (i%2 == 0 && j%2 == 0)) {
                    if (chessArr[i][j].equals("F")){
                        count++;
                    }
                }
            }
        }
        bw.write(count + "");

        bw.flush();
        bw.close();
    }
}