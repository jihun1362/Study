package 항해_알고리즘;

class Solution11 {
    public int solution(int num) {
        int answer = 0;

        long n=num;
        if (n == 1) {
            answer = 0;
        } else {
            while (true) {
                if (answer > 500) {
                    answer = -1;
                    break;
                } else if (n == 1) {

                    break;
                }
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = n * 3 + 1;
                }
                answer++;
            }
        }
        return answer;
    }
}

public class Num11 {
    public static void main(String[] args) {
        int num = 626331;

        int a = 0;
        long n=num;
        if (n == 1) {
            a = 0;
        } else {
            while (true) {
                if (a > 500) {
                    a = -1;
                    break;
                } else if (n == 1) {
                    System.out.println(n);
                    break;
                }
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = n * 3 + 1;
                }
                System.out.println(n);
                a++;
            }
        }
        System.out.println(a);
    }
}
