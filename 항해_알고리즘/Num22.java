package 항해_알고리즘;

class Solution22 {
    public int solution(String s) {
        int answer = 0;

        return answer;
    }
}

public class Num22 {
    public static void main(String[] args) {
        String s="one4seveneight";
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < numbers.length; i++) {
            s = s.replaceAll(numbers[i], String.valueOf(i));
        }
        int answer = Integer.parseInt(s);
        System.out.println(answer);

    }
}
