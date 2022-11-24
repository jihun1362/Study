package 항해_알고리즘;

import java.util.*;
class Solution16 {
    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);

        ArrayList<String> totalArr = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                totalArr.add(String.valueOf(numbers[i] + numbers[j]));
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            totalArr.remove(String.valueOf(numbers[i] + numbers[i]));
        }
        HashSet<String> setarr = new HashSet<>(totalArr);
        ArrayList<String> totalArr2 = new ArrayList<>(setarr);
        ArrayList<Integer> totalArr3 = new ArrayList<>();
        for (int i = 0; i < totalArr2.size(); i++){
            System.out.println(Integer.parseInt(totalArr2.get(i)));
            totalArr3.add(Integer.parseInt(totalArr2.get(i)));
        }
        int[] answer = totalArr3.stream().sorted().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}

public class Num16 {
    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};


        //{2,1,3,4,1};
        ArrayList<String> totalArr = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                totalArr.add(String.valueOf(numbers[i] + numbers[j]));
            }
        }
        HashSet<String> setarr = new HashSet<>(totalArr);
        System.out.println(totalArr);
        int[] answer = setarr.stream().mapToInt(Integer::parseInt).sorted().toArray();
        for (int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
