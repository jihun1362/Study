package 항해_알고리즘;


import java.util.Arrays;
import java.util.Collections;
class Solution8 {
    public long solution(long n) {

        String[] a = String.valueOf(n).split("");
        Arrays.sort(a, Collections.reverseOrder());

        StringBuffer b= new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            b.append(a[i]);
        }

        return Long.valueOf(String.valueOf(b));
    }
}

public class Num8 {
    public static void main(String[] args) {
        long n = 118372;
        String[] a = String.valueOf(n).split("");
        Arrays.sort(a, Collections.reverseOrder());

        StringBuffer b= new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            b.append(a[i]);
        }
        System.out.println(Long.valueOf(String.valueOf(b)));

    }
}
