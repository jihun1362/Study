package 항해_알고리즘;

import java.util.ArrayList;

class Solution18 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        return answer;
    }
}

public class Num18 {
    public static void main(String[] args) {
        int[] answers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        //찍는 방식 선언
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        //찍는 방식 Count
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        //맞은 점수 Count
        int a1 = 0;
        int b1 = 0;
        int c1 = 0;


        for (int i = 0; i < answers.length; i++) {
            //찍는 방식 Count 리셋
            if (aCount == 5) {
                aCount = 0;
            }
            if (bCount == 8) {
                bCount = 0;
            }
            if (cCount == 10) {
                cCount = 0;
            }

            //맞은 점수
            if (answers[i] == a[aCount]) {
                a1++;
            }
            if (answers[i] == b[bCount]) {
                b1++;
            }
            if (answers[i] == c[cCount]) {
                c1++;
            }

            //찍는 방식 Count++
            aCount++;
            bCount++;
            cCount++;
        }

        //출력 조건식
        ArrayList<Integer> list = new ArrayList<>();
        if (a1 > b1 && a1 > c1) {
            list.add(1);
        } else if (a1 == b1 && a1 > c1) {
            list.add(1);
            list.add(2);
        } else if (a1 > b1 && a1 == c1) {
            list.add(1);
            list.add(3);
        } else if (a1 == b1 && a1 == c1) {
            list.add(1);
            list.add(2);
            list.add(3);
        } else if (b1 > a1 && b1 > c1) {
            list.add(2);
        } else if (b1 > a1 && b1 == c1) {
            list.add(2);
            list.add(3);
        } else {
            list.add(3);
        }

        //형변환
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
