package 항해_알고리즘;

import java.util.ArrayList;
import java.util.Stack;

import java.util.ArrayList;
class Solution13 {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> a = new ArrayList<>();
        int count = 0;
        while (true) {
            count++;
            a.add(n % 3);
            n = n / 3;
            if (n == 0) break;
        }
        int b = a.size() - 1;
        int c = 1;
        int d=0;

        for (int i = a.size() - 1; i >= 0; i--) {
            if (i == b) {
                answer += a.get(i);
            } else {
                for (int j = 1; j <= d; j++) {
                    c *= 3;
                }
                answer += a.get(i) * c;
            }
            d++;
            c=1;
        }
        return answer;
    }
}

public class Num13 {
    public static void main(String[] args) {
        int n = 125;

        int answer = 0;
        ArrayList<Integer> a = new ArrayList<>();

        int count = 0;

        while (true) {
            count++;
            a.add(n % 3);
            n = n / 3;
            if (n == 0) break;
            System.out.println(n);
        }
        System.out.println(a);
        int b = a.size() - 1;
        int c = 1;
        int d=0;

        for (int i = a.size() - 1; i >= 0; i--) {
            if (i == b) {
                answer += a.get(i);
                System.out.println("ehlsk?");
                System.out.println(a.get(i));
            } else {
                for (int j = 1; j <= d; j++) {
                    c *= 3;
                }
                answer += a.get(i) * c;
                System.out.println(a.get(i)*c);
            }
            d++;
            c=1;
        }
        System.out.println(answer);
    }
}
