package 항해_알고리즘;

class Solution9 {
    public long solution(long n) {
        long answer = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n == i * i) {
                answer += (i + 1) * (i + 1);
                break;
            }
        }
        if (answer == 0) {
            answer -= 1;
        }
        return answer;
    }
}

public class Num9 {
    public static void main(String[] args) {
        long n = 5000000;
        long answer = 0;


        for (long i = 1; i * i <= n; i++) {
            if (n == i * i) {
                answer += (i + 1) * (i + 1);
                break;
            }
        }
        if (answer == 0) {
            answer -= 1;
        }


        System.out.println(answer);
    }
}
