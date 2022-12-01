package Question.BaekjoonAlgorithm;
//더하기 사이클

import java.util.Scanner;

public class Num1110 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N=console.nextInt();

        String[] num1;

        //num1을 둘로바꿔서 더한 수
        int num2;

        //더해서 나온 계속 바뀌는 수
        int num3 = 0;

        //카운트
        int idx = 0;

        //루프
        while (true) {
            //1자리수 앞에 0추가
            if ((num3<10&&num3>0)){
                num1 = (0+String.valueOf(num3)).split("");
            } else if ((N<10&&N>=0)&&num3 == 0) {
                num1 = (0+String.valueOf(N)).split("");
            } else {
                if (num3 == 0) {
                    num1 = String.valueOf(N).split("");
                } else {
                    num1 = String.valueOf(num3).split("");
                }
            }

            //num1 둘로 분리해서 더하기
            num2 = Integer.parseInt(num1[0]) + Integer.parseInt(String.valueOf(num1[1]));
            if (num2<10){
                //더한수가 한자리수이면 num1뒷자리하고 String로 합쳐서 두자리로 만들고 숫자로변환
                num3 = Integer.parseInt(num1[1] + num2);
            }else {
                //더한수가 두자리면 num1의 뒷자리와 num2의 뒷자리 합치고 숫자로 변환
                String[] num2_1 = String.valueOf(num2).split("");
                num3 = Integer.parseInt((num1[1] + num2_1[num2_1.length - 1]));
            }
            //카운트
            idx++;

            //num3가 N과 같은수가되면 break;
            if (N == num3) {
                break;
            }
        }
        System.out.println(idx);
    }
}
