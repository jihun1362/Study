package Question.BaekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Fly me to the Alpha Centauri
public class Num1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        for (String s : str) System.out.println(Integer.parseInt(s));


        //맨밑에 주석으로 처리한것을 보면 수가 중복되게 증가함을 알수있음
        int answer = 0;
        for (int i = 2; i < str.length; i+=2) {
            int num = Integer.parseInt(str[i]) - Integer.parseInt(str[i-1]);
            if (0 < num && num < 4) {
                //num이 1~4일때는 무조건 3
                answer = 3;
            } else if ((num - 4) % 3 == 0) {
                //num에서 위에 4개의 상황을 빼서 num-4하고 그 수를 3으로 나눴을때 나머지가 0이면 이 식 진행
                //예를들어 7일때 -4하면 3으로 나머지가 0 밑에 식을 진행하면 3/3=1에 1+3하니까 4
                //그러나 5,6일경우는 3보다 작아져 나눴을때 1이 안나오기 때문에 4의 값이 안나옴
                //그래서 마지막 else식으로 +3이 아닌 +4로 하여 진행
                answer = (num - 4) / 3 + 3;
            } else
                answer = (num - 4) / 3 + 4;
            System.out.println(answer);
        }

//        if (num == 1 || num == 2 || num == 3 || num == 4) {//3
//            answer = 3;
//        } else if (num == 5 || num == 6 || num == 7) {//4 1211,1221,1231
//            answer = (num - 4) / 3 + 3; num == 7
//            answer = (num - 4) / 3 + 4; num == 5,6
//        } else if (num == 8 || num == 9 || num == 10) {//5 12311,12321,12331
//
//        } else if (num == 11) {//6 123311
//
//        }


    }
}
