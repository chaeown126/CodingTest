# [Silver II] 사탕 게임 - 3085 

[문제 링크](https://www.acmicpc.net/problem/3085) 

### 성능 요약

메모리: 14300 KB, 시간: 176 ms

### 분류

브루트포스 알고리즘, 구현

### 제출 일자

2024년 2월 23일 18:39:43

### 문제 설명

<p>상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.</p>

<p>가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.</p>

<p>사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)</p>

<p>다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.</p>

<p>사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.</p>


### 출력 

 <p>첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.</p>
 
---
너무 어렵게 돌아갔던 문제. 완전탐색(브루트포스) 알고리즘 문제라면 충분한 시간이 주어지기 때문에 효율적이게 짜려는 노력은 좀 덜 해도 된다는 걸 느꼈다.. (물론 효율적이면 더 좋겠지만!)    
완전탐색이면 아무래도 효율과는 먼데 어떻게든 효율을 찾으려고 해서 더 어려웠던 것 같다 🥲  
### 소스 설명
처음에 세웠던 계획은 아래와 같다.
```java
// 1. 행을 기준으로 1부터 n까지, 열을 기준으로 1부터 n까지 아래로 내려감, 이중 for문을 두 번? => i-1 인덱스와 비교
// 2. 바꿀 때마다 전체 탐색.. 은 너무 비효율적일 듯,
// 3-1. 행 체인지 -> 바뀐 행들이 포함된 한 개의 행 + 바뀐 행들이 포함된 두 개의 열
// 3-2. 열 체인지 -> 바뀐 열들이 포함된 한 개의 열 + 바뀐 열들이 포함된 두 개의 행
// 4. 체인지 할 때마다 count 세주고 max 함수 이용해서 max 변수에 계속 업데이트 해주기, 함수 끝나면 0으로 초기화
// 5. 최대 개수는 n을 초과할 수 없음, 만약에 count가 n이랑 같을 경우에 바로 return 시켜서 끝내기
```

그리고 결과적으로 느낀 것과 해결법
1. ```3-1``` 이랑 ```3-2``` 가 너무 욕심이었다🙃 사탕 색상이 바뀔 때마다 전체를 탐색하는 건 너무 비효율적일 것이라 생각(```2```)해서 자리가 바뀐 사탕이 행끼리 바뀐건지, 열끼리 바뀐건지에 따라 다른 탐색을 하도록 짰는데, 무리였는지.. 소스만 길어지고 더 복잡해지기만 했다. 그리고 잘 짰어도 엄청난 효율을 불러오진 않았을 것 같다.    
다 풀고 찾아보니, 전체 탐색을 할 때의 시간복잡도는 ```O(N^2)``` 이고 ```N <= 50``` 이기 때문에 충분하다고.. (이래서 시간복잡도 공부도 중요한가보다!)   
2. static 변수로 사탕 색상별 count를 세려고 했다.. 심지어 switch-case 까지 써서 더 복잡해졌는데, 그냥 이중 for문에서 하나의 count로 해결볼 수 있었다.
3. 처음에 isComplete 라는 boolean 변수를 사용해서 ```5``` 의 조건을 추가한 상태로 문제를 해결했는데, 시험 삼아 빼봤는데도 시간 상으로 차이가 없어서 제거하였다.
   BOJ 기준이긴 하지만 메모리는 ```14468 KB``` => ```14304 KB``` 로 줄어서 빼기를 잘했다고 생각한다..
```java
import java.io.*;

public class Main {
    static int max = 0;
    static char bomboni[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        bomboni = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                bomboni[i][j] = str.charAt(j);
            }
        }

        checkCurrentCandy(bomboni); // 입력값 그대로를 탐색

        candyChange(true, bomboni); // 행
        candyChange(false, bomboni); // 열

        sb.append(max);
        System.out.print(sb);
    }

    private static void checkCurrentCandy(char bomboni[][]) {
        for(int i = 0; i < bomboni.length; i++) {
            for(int j = 0; j < bomboni.length; j++) {
                getMaxCount(bomboni);
            }
        }
    }

    private static void candyChange(boolean direction, char bomboni[][]) {
        if(direction) { // 행 기준으로 색상을 바꾼다
            for(int i = 0; i < bomboni.length; i++) {
                for(int j = 1; j < bomboni.length; j++) {
                    if(bomboni[i][j] != bomboni[i][j-1]) {
                        // 색상 교체
                        char tempCandy = bomboni[i][j];
                        bomboni[i][j] = bomboni[i][j-1];
                        bomboni[i][j-1] = tempCandy;

                        // 최대 개수 구하는 함수 호출
                        getMaxCount(bomboni);

                        // 색상 원복
                        bomboni[i][j-1] = bomboni[i][j];
                        bomboni[i][j] = tempCandy;
                    }
                }
            }
        } else { // 열 기준으로 색상을 바꾼다
            for(int i = 1; i < bomboni.length; i++) {
                for(int j = 0; j < bomboni.length; j++) {
                    if(bomboni[i][j] != bomboni[i-1][j]) {
                        // 색상 교체
                        char tempCandy = bomboni[i][j];
                        bomboni[i][j] = bomboni[i-1][j];
                        bomboni[i-1][j] = tempCandy;

                        // 최대 개수 구하는 함수 호출
                        getMaxCount(bomboni);

                        // 색상 원복
                        bomboni[i-1][j] = bomboni[i][j];
                        bomboni[i][j] = tempCandy;
                    }
                }
            }
        }
    }

    private static void getMaxCount(char bomboni[][]) {
        // 행을 기준으로 max 값 구함
        for (int i = 0; i < bomboni.length; i++) {
            int count = 1;
            for (int j = 0; j < bomboni.length - 1; j++) {
                if (bomboni[i][j] == bomboni[i][j + 1]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

        // 열을 기준으로 max 값 구함
        for (int i = 0; i < bomboni.length; i++) {
            int count = 1;
            for (int j = 0; j < bomboni.length - 1; j++) {
                if (bomboni[j][i] == bomboni[j + 1][i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
    }
}
```
완전 탐색이 아직 어렵다. 더 많이 풀고 익숙해져야지! 🫠

