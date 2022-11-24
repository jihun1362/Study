package 항해_알고리즘;

import java.util.*;
class Solution6 {
    public int solution(int n) {
        int answer = 0;

        String a=String.valueOf(n);
        for (int i=0; i<a.length();i++){
            answer += Integer.parseInt(String.valueOf(a.charAt(i)));
        }
        return answer;
    }
}

public class Num6 {
    public static void main(String[] args) {
        int answer = 0;
        int n=123;

        String a=String.valueOf(n);
        for (int i=0; i<a.length();i++){
            answer += Integer.parseInt(String.valueOf(a.charAt(i)));
        }

        System.out.println(answer);
    }
}
