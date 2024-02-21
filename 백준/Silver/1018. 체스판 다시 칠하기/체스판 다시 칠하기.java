import java.io.*;

public class Main {
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String nmStr = br.readLine();
        int n = Integer.parseInt(nmStr.split(" ")[0]);
        int m = Integer.parseInt(nmStr.split(" ")[1]);
        char chessArr[][] = new char[n][m];

        // 1. 체스판 정보를 boolean 배열에 넣어줌
        for(int i = 0; i < chessArr.length; i++) {
            nmStr = br.readLine();
            for(int j = 0; j < nmStr.length(); j++) {
                chessArr[i][j] = nmStr.charAt(j);
            }
        }

        // 2. (1,1)이 W(true)인 경우와 B(false)인 경우
        chessBoard('B', chessArr, n, m);
        chessBoard('W', chessArr, n, m);

        sb.append(min);
        System.out.print(sb);
    }

    // color에 따른 기준 좌표(8*8 기준으로 (0,0)) 지정
    private static void chessBoard(char color, char[][] chessArr, int n, int m) {
        for(int i = 0; i < (n-7); i++) {
            for(int j = 0; j < (m-7); j++) {
                getMinCount(color, chessArr, i, j);
            }
        }
    }

    // color를 기준으로 i와 j가 모두 홀수일 때, i와 j가 모두 짝수일 때만 동일한 color가 들어있어야 함
    private static void getMinCount(char color, char[][] chessArr, int i, int j){
        int count = 0;
        for(int k = i; k < (i+8); k++) {
            for(int l = j; l < (j+8); l++) {
                if(color == chessArr[k][l]) {
                   if(!(((k-i+2) % 2 == 0 && (l-j+2) % 2 == 0) || ((k-i+2) % 2 == 1 && (l-j+2) % 2 == 1))) {
                        count++;
                    }
                } else {
                   if(((k-i+2) % 2 == 0 && (l-j+2) % 2 == 0) || ((k-i+2) % 2 == 1 && (l-j+2) % 2 == 1)) {
                        count++;

                    }
                }
            }
        }
        // min 설정
        min = Math.min(min, count);
    }
}