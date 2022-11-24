package 항해_알고리즘;

import java.util.*;
import java.util.stream.Stream;
class Solution7 {
    public int[] solution(long n) {

        String[] a = String.valueOf(n).split("");

        String[] b= new String[a.length];

        int j=0;
        for (int i=a.length-1;i< a.length;i--){
            b[j]=a[i];
            j += 1;
            if (i==0) {
                break;
            }
        }

        int[] answer = Stream.of(b).mapToInt(Integer::parseInt).toArray();
        return answer;
    }
}

public class Num7 {
    public static void main(String[] args) {
//        int[] answer = {};
        int n = 1168765469;

        String[] a = String.valueOf(n).split("");

        String[] b= new String[a.length];

        int j=0;
        for (int i=a.length-1;i< a.length;i--){
            b[j]=a[i];
            j += 1;
            if (i==0) {
                break;
            }
        }

        int[] answer = Stream.of(b).mapToInt(Integer::parseInt).toArray();
    }
}
