package 항해_알고리즘;

import java.util.ArrayList;

class Solution31 {
    public int solution(int n) {
        int answer = 0;
        return answer;
    }
}

public class Num31 {
    public static void main(String[] args) {
        int n = 10;
        int answer = 0;
//!!!!!!!!!!!에라토스테네스의 체!!!!!!!!!
//        // n+1만큼 할당
//        ArrayList<Integer> sosu = new ArrayList<>(n + 1);
//
//        // 0번째와 1번째를 소수 아님으로 처리
//        sosu.add(0);
//        sosu.add(0);
//
//        // 2 ~ n까지 소수로 설정
//        for (int i = 2; i <= n; i++) sosu.add(i, 1);
//
//        // 각각의 배수들을 지워간다.
//        for (int i = 2; (i * i) <= n; i++) {
//            if (sosu.get(i) == 1) {
//                for (int j = i * i; j <= n; j += i) sosu.set(j, 0);
//            }
//        }
//
//        for (int i = 0; i <= n; i++) {
//            if (sosu.get(i) == 1) {
//                answer++;
//            }
//        }
//        System.out.println(answer);

        int[] sosu2 = new int[n + 1];

        sosu2[0] = 0;
        sosu2[1] = 0;

        for (int i = 2; i <= n; i++) sosu2[i] = 1;

        for (int i = 2; (i * i) <= n; i++) {
            if (sosu2[i] == 1) {
                for (int j = i * i; j <= n; j += i) sosu2[j] = 0;
            }
        }

        for (int i = 0; i <= n; i++) {
            if (sosu2[i] == 1) {
                answer++;
            }
        }
        System.out.println(answer);
//        int minAnswer = 0;
//
//        for (int i = 2; i * i <= n; i++) {
//            for (int j = i * i; j <= n; j += i) {
//                ++minAnswer;
//            }
//        }
//
//        System.out.println(answer = n - minAnswer - 1);
    }
}
