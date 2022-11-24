package 항해_알고리즘;

import java.util.Arrays;

class Solution2_ {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter((a) -> a % divisor == 0)
                .sorted()
                .toArray();


        if (answer.length==0){
            int[] answer1 = {-1};
            answer=answer1;
        }



        return answer;
    }
}


public class Num2 {
    public static void main(String[] args) {

        int[] arr = {5, 9, 7, 10};
        int divisor = 15;

        int[] answer = Arrays.stream(arr)
                .filter((a) -> a % divisor == 0)
                .sorted()
                .toArray();

        if (answer.length==0){
            int[] answer1 = {-1};
            answer=answer1;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }


    }
}
