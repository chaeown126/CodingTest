# [level 2] 소수 찾기 - 42839 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42839) 

### 성능 요약

메모리: 78.1 MB, 시간: 9.80 ms

### 구분

코딩테스트 연습 > 완전탐색

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 2월 0일 2:13:24

### 문제 설명

<p>한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.</p>

<p>각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>numbers는 길이 1 이상 7 이하인 문자열입니다.</li>
<li>numbers는 0~9까지 숫자만으로 이루어져 있습니다.</li>
<li>"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>numbers</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>"17"</td>
<td>3</td>
</tr>
<tr>
<td>"011"</td>
<td>2</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>예제 #1<br>
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.</p>

<p>예제 #2<br>
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.</p>

<ul>
<li>11과 011은 같은 숫자로 취급합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges

---
## 🛠️ 소스 설명
1. DFS 알고리즘을 사용할 것
2. 순열(중복 허용X)을 사용할 것
3. 에라토스테네스의 체 알고리즘을 사용할 것

```java
import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> permArr = new ArrayList<>();
    public int solution(String numbers) {
        // 1. 입력받은 문자열을 하나씩 쪼개기 위한 과정을 진행함 
        String[] strArr = numbers.split("");
        int[] numberArr = new int[strArr.length];
        int count =  0;
        // 문자열 배열에 담긴 각각의 문자(숫자)를 다시 정수 배열에 반복문으로 넣어줌
        for(int i = 0; i < strArr.length; i++) {
            numberArr[i] = Integer.parseInt(strArr[i]);
        }

        // 2. 1 ~ n 자릿수로 조합 시작 
        for(int r = 1; r <= numberArr.length; r++) {
            permutation(numberArr, new int[r], new boolean[numberArr.length], 0, r); // 순열 함수 호출
        }

        // 3. permArr에 담긴 숫자들을 대상으로 소수 판별 + count 계산 
        for(int i = 0; i < permArr.size(); i++) {
            // get한 숫자가 소수일 경우 count+1
            if(isPrime(permArr.get(i))) {
                count++;
            }
        }
        // 최종 count 수를 return함함
        return count;
    }

    /* [핵심 부분] DFS + 순열(중복 허용X) */
    // numberArr : 순열처리 해야하는 배열
    // out : 완성된 순열이 들어갈 배열
    // visited : 중복 방지용 배열 (현재 인덱스의 숫자는 또 뽑히지 않도록)
    // depth : 트리의 깊이, DFS를 돌면서 인접 노드와 그에 대한 자식 노드를 접근할 때 사용함
    // r : 순열의 자릿수(?)
    private static void permutation(int[] numberArr, int[] out, boolean[] visited, int depth, int r){
        if(depth == r) {
            int num = 0;
            for(int i : out) {
                num = Integer.parseInt(num + "" + i);
            }
            // 중복되는 숫자가 있을 수 있으므로 contains 함수로 조건 걸어줌
            if(!permArr.contains(num)) permArr.add(num);
            return;
        }
        for(int i = 0; i < numberArr.length; i++) {
            // 아직 방문하지 않은 인덱스인 경우
            if(!visited[i]) {
                visited[i] = true; // 방문 처리
                out[depth] = numberArr[i]; // 현재 노드의 값을 out 배열에 넣어 순열을 만듦
                permutation(numberArr, out, visited, depth + 1, r); // depth+1로 현재 노드의 인접 노드로 이동 (재귀함수)
                visited[i] = false;
            }
        }
    }

    // 소수 판별용 함수
    private static boolean isPrime (int number) {
        if(number < 2) return false; // 2보다 작은 정수는 소수가 아니기 때문에 제일 먼저 return false 처리
        int cnt = 0; // 소수 개수 카운팅 변수

        // 에라토스테네스의 체 방식 사용
        // number의 약수가 있는지 판별함
        for(int i = 2; i*i <= number; i++) {
            if(number % i == 0) return false;
        }
        // 반복문이 끝나면 number가 소수인 것이기 때문에 true를 return함
        return true;
    }
}
```
