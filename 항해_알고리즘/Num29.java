package 항해_알고리즘;

import java.util.*;

class Solution29 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        return answer;
    }
}

public class Num29 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = new int[commands.length];;

        List<Integer> arrayList = new ArrayList<>();
        for (Integer i : array) {
            arrayList.add(i);
        }
        for (int i = 0; i < commands.length; i++) {
            List<Integer> subList = new ArrayList<>(arrayList);
            subList = arrayList.subList(commands[i][0] - 1, commands[i][1]);
            System.out.println(subList);
            List<Integer> sortList = new ArrayList<>(subList);
            sortList.sort(Comparator.naturalOrder());
            System.out.println(sortList);
            answer[i] = sortList.get(commands[i][2] - 1);
        }
        for (int j = 0; j < answer.length; j++) {
            System.out.println(answer[j]);
        }
    }
}
