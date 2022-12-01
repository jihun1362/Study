package Question.BaekjoonAlgorithm;

import java.util.Scanner;
//설탕배달
public class Num2839 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N = console.nextInt();
        int answer = 0;

        //예외 제거
        if (N == 1 || N == 2 || N == 4 || N == 7) {
            answer = -1;
            System.out.println(answer);
        } else {
            int[] kg = {3, 5};
            int totalKg = 0;
            int count = 0;


            while (totalKg != N) {
                if (N % 5 == 0) {
                    //5의 배수면 딱 떨어지게 돌리기
                    totalKg += kg[1];
                    count++;
                } else {
                    //5의 배수가 아니면 5가 딱 한번 더 초과되게 돌리기
                    totalKg += kg[1];
                    count++;
                    //6일때  3두번이여야 하지만 5가 두번 돌면 어쨌든 두개
                    //18일때도 마찬가지로 5의 배수만큼 돌고 3을 한번 더 가져오면 되니까 총 4개로 5가 한번 더 초과해서 가져온 갯수랑 동일
                }
                if (totalKg > N) break;
            }
            if (N%5==4||N%5==2)count++;
            //나머지가 4나 2로 떨어지는 경우는 3이 3개나 4개가 필요하다보니 1개 초과 되는 것보다도 1개가 더 있어야됨
            //12일때 3은 총4개 위에식대로하면 5가 한번 초과되서 3개 여기에 +1되야 동일해짐
            //마찬가지로 14도 원래라면 5하나에 3세개로 총 4개이나 위에 식대로하면 5하나초과해서 3개에 1개가 더 필요하기에 하나 더추가해야 동일
            answer+=count;
            System.out.println(answer);
        }
    }
}
