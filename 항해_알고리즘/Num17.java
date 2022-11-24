package 항해_알고리즘;

import java.util.Arrays;

class Solution17 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < lottos.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    answer[0] -= 1;
                    answer[1] -= 1;
                }
            }
            if (lottos[i] == 0) {
                answer[0] -= 1;
            }
        }
        if (answer[1] == 7)
            answer[1] = 6;

        if (answer[0] == 7)
            answer[0] = 6;
        return answer;
    }
}

public class Num17 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] answer = {7, 7};


        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < lottos.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    answer[0] -= 1;
                    answer[1] -= 1;
                }
            }
            if (lottos[i] == 0) {
                answer[0] -= 1;
            }
        }

        if (answer[1] == 7)
            answer[1] = 6;
        if (answer[0] == 7)
            answer[0] = 6;


    }
}
