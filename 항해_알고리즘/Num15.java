package 항해_알고리즘;

import java.util.*;
import java.util.stream.Stream;

import java.util.*;

class Solution15 {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> a = new ArrayList<>();
        a.add(arr[0]);
        int b = 1;
        for (int i = 1; i < arr.length; i++) {
            if (a.get(b - 1) != (arr[i])) {
                a.add(arr[i]);
                b++;
            }
        }
        answer = a.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

public class Num15 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        ArrayList<Integer> a = new ArrayList<>();
        //{4,4,4,3,3};
        a.add(arr[0]);
        System.out.println(a.get(0));
        int b = 1;

        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
            if (a.get(b - 1) != (arr[i])) {
                a.add(arr[i]);
                b++;
            }
        }
        System.out.println(a);
        int[] answer = a.stream().mapToInt(Integer::intValue).toArray();


//        int bSize = 0;
//        for (int i = 0; i < b.size(); i++) {
//            if (a.size() == i - 2) {
//                break;
//            } else {
//                if (a.get(i).equals(b.get(i + 1))) {
//                    a.remove(i + 1);
//                }
//            }
//            bSize+=1;

//            if (i == a.size() - 1) {
//                if (a.get(i) == a.get(a.size() - 1)) {
//
//                    break;
//                }
//                break;
//            } else {
//                if (a.get(i).equals(a.get(i + 1))) {
//                    a.remove(a.get(i + 1));
//                    continue;
//                }
//            }


    }
}