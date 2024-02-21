# [Silver IV] 체스판 다시 칠하기 - 1018 

[문제 링크](https://www.acmicpc.net/problem/1018) 

### 성능 요약

메모리: 14292 KB, 시간: 136 ms

### 분류

브루트포스 알고리즘

### 제출 일자

2024년 2월 21일 18:22:39

### 문제 설명

<p>지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.</p>

<p>체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.</p>

<p>보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.</p>

### 출력 

 <p>첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.</p>

---
역대급 어려웠던 문제.. 완전탐색 너란 아이.. 참 무서운 친구구나    
반례를 찾기 힘들어서 더 걸렸던 문제였다 🥲    
풀었으니 까먹지 않게 소스 리뷰하기 !

## 소스 설명
```java
import java.io.*;

public class Main {
    static int min = 64; // 최대 8*8의 값까지 나올 수 있으므로 min 값을 64로 설정함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 입력받은 n과 m으로 2차원 character형 배열을 생성함
        String nmStr = br.readLine();
        int n = Integer.parseInt(nmStr.split(" ")[0]);
        int m = Integer.parseInt(nmStr.split(" ")[1]);
        char chessArr[][] = new char[n][m];

        // 2. 체스판 정보를 char 배열에 넣어줌
        for(int i = 0; i < chessArr.length; i++) {
            nmStr = br.readLine();
            for(int j = 0; j < nmStr.length(); j++) {
                chessArr[i][j] = nmStr.charAt(j);
            }
        }

        // 3. (0,0)이 B로 시작하는 경우와 W로 시작하는 경우가 따로 있기 때문에 해당 함수를 각각 한 번씩, 총 두번 호출
        chessBoard('B', chessArr, n, m);
        chessBoard('W', chessArr, n, m);

        sb.append(min);
        System.out.print(sb);
    }

    // 4. color에 따른 기준 좌표(8*8 기준으로 (0,0)) 지정
    private static void chessBoard(char color, char[][] chessArr, int n, int m) {
        // 최대 길이가 8을 넘을 수 없기 때문에 전체 길이(n) - 7로 반복 진행
        for(int i = 0; i < (n-7); i++) {
            for(int j = 0; j < (m-7); j++) {
                getMinCount(color, chessArr, i, j);
            }
        }
    }

    // 5. color를 기준으로 i와 j가 모두 홀수일 때, i와 j가 모두 짝수일 때만 동일한 color가 들어있어야 함
    private static void getMinCount(char color, char[][] chessArr, int i, int j){
        int count = 0;
        for(int k = i; k < (i+8); k++) {
            for(int l = j; l < (j+8); l++) {
                // ** 변경이 필요한 체스판만 조건 걸리도록 해야함
                // 5-1. (0,0)의 색상과 현재 좌표의 색상이 같을 경우
                if(color == chessArr[k][l]) {
                    // (i짝 && j짝) 또는 (i홀 && j홀)일 경우에는 올바른 체스판이므로 반대 조건으로 !을 붙여 count 시킴
                    // 홀/짝을 구별하려고 했는데 0이나 1은 %2의 결과가 정확한 카운팅이 되지 않았음.. 그래서 아예 뺀값에 2를 더해서 홀/짝은 유지하고 나머지도 구할 수 있게끔 했더니 개선됨
                    if(!(((k-i+2) % 2 == 0 && (l-j+2) % 2 == 0) || ((k-i+2) % 2 == 1 && (l-j+2) % 2 == 1))) { // k-i 와 l-j를 했어야 했는데 처음에 l도 -i를 해버렸어서 수정했더니 성공!
                        count++;
                    }
                // 5-2. (0,0)의 색상과 현재 좌표의 색상이 다를 경우
                } else {
                    // (i-n짝 && j-n짝) 또는 (i-n홀 && j홀)일 경우에는 올바른 체스판이므로 반대 조건으로 !을 붙여 count 시킴
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
```
