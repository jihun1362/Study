package 항해_알고리즘;

import java.util.ArrayList;
import java.util.HashSet;

class Solution28 {
    public int[] solution(int n, int m) {
        int[] answer = {};
        return answer;
    }
}

public class Num28 {
    public static void main(String[] args) {
        int n = 3;
        int m = 12;

        long[] answer = {};
        ArrayList<Integer> nlist = new ArrayList<>();
        ArrayList<Integer> mlist = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) nlist.add(i);
        }
        for (int i = 1; i <= m; i++) {
            if (m % i == 0) mlist.add(i);
        }
        ArrayList<Integer> yaksu = new ArrayList<>(nlist);
        yaksu.retainAll(mlist);
        answer = new long[]{yaksu.get(yaksu.size()-1),  ((long)(n * m) / (long)yaksu.get(yaksu.size()-1))};

        for (long i:answer){
            System.out.println(i);
        }
//        int x = 0;
//        int i = 1;
//        int x1 = 1;
//        int j = 1;
//        int x2 = 0;
//        while (true) {
//            if (x1 == x2) {
//                x += x2;
//                break;
//            } else if (x2 > x1) {
//                x1 = m * j;
//                j++;
//            } else {
//                x2 = n * i;
//                i++;
//            }
//        }
//
//        answer[0]=yaksulist.get(yaksulist.size()-1);
//        answer[1]=x;
//        System.out.println(x);
    }
}
