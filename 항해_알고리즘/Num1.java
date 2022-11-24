package 항해_알고리즘;

class Solution1 {
    public String solution(int a, int b) {
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int monthTotalDays = 0;
        int totalDays = 0;

        for (int i = 0; i < a - 1; i++) {
            monthTotalDays += months[i];
        }
        if (a == 1) {
            totalDays += b;
        } else
            totalDays += monthTotalDays + b;

        int num = (totalDays - 1) % 7;

        String answer = days[num];

        return answer;
    }
}
//2016년 1월 1일은 금요일입니다.2016년 a월 b일은 무슨 요일일까요?
//2016년은 윤년입니다.
public class Num1 {
    public static void main(String[] args) {
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int a = 1;
        int b = 8;

        int monthTotalDays = 0;
        int totalDays = 0;

        for (int i = 0; i < a - 1; i++) {
            monthTotalDays += months[i];
        }
        if (a == 1) {
            totalDays += b;
        } else
            totalDays += monthTotalDays + b;

        int num = (totalDays - 1) % 7;

        String answer = days[num];

        System.out.println(num);
        System.out.println(answer);

    }
}
