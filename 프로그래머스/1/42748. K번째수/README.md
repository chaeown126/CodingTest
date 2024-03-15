# [level 1] K번째수 - 42748 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42748) 

### 성능 요약

메모리: 77.1 MB, 시간: 0.29 ms

### 구분

코딩테스트 연습 > 정렬

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 03월 14일 17:35:55

### 문제 설명

<p>배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.</p>

<p>예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면</p>

<ol>
<li>array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.</li>
<li>1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.</li>
<li>2에서 나온 배열의 3번째 숫자는 5입니다.</li>
</ol>

<p>배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>array의 길이는 1 이상 100 이하입니다.</li>
<li>array의 각 원소는 1 이상 100 이하입니다.</li>
<li>commands의 길이는 1 이상 50 이하입니다.</li>
<li>commands의 각 원소는 길이가 3입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>array</th>
<th>commands</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>[1, 5, 2, 6, 3, 7, 4]</td>
<td>[[2, 5, 3], [4, 4, 1], [1, 7, 3]]</td>
<td>[5, 6, 3]</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.<br>
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.<br>
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges

---
### 소스 설명
1. int형 배열의 원소들을 String형 배열에 다시 넣어줄 것
2. compareTo 로 Sort 진행
3. 정렬 후 첫 번째 문자열이 "0"일 경우, 바로 "0"을 return
4. 정렬된 최종 문자열 배열을 한 번에 합쳐 return

```java
import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. int형 배열의 원소들을 String형 배열에 다시 넣어줄 것
        String[] numArr = new String[numbers.length];
        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = String.valueOf(numbers[i]);
        }

        // 2. compareTo 로 Sort 진행
        Arrays.sort(numArr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        // 3. 정렬 후 첫 번째 문자열이 "0"일 경우, 바로 "0"을 return
        if(numArr[0].equals("0")) return "0";

        // 4. 정렬된 최종 문자열 배열을 한 번에 합쳐 return
        return String.join("", numArr);
        
    }
}
```
각 자릿수마다 비교하는 방식으로 풀면 되지 않을까 라곤 생각했는데..   
```compareTo``` 함수로 ```(o2+o1)```과 ```(o1+o2)```를 비교해볼 생각은 전혀 못했다ㅠㅠ   
```compareTo``` 함수를 많이 이용해보거나 ```Comparator```를 잘 알았다면 생각해냈을텐데...    

정렬이 많은 알고리즘 중에 비교적 쉽겠지만 그렇다고 얕보진 말아야겠다는 생각을 했다!   
그리고 ```compareTo```도 다른 문제에서 활용해볼 수 있도록 알아봐야겠다 🙃
