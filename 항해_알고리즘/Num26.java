package 항해_알고리즘;

class Solution26 {
    public int solution(int n) {
        int answer = 0;
        return answer;
    }
}

public class Num26 {
    public static void main(String[] args) {
        int n = 12;


        int answer = 0;



        for (int i = 1; i <= n; i++) {
            if (n % i == 0) answer+=i;
        }
        System.out.println(answer);

    }
}
