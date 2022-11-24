package 항해_알고리즘;

import java.util.ArrayList;
import java.util.Arrays;

class Solution10 {
    public int[] solution(int[] arr) {
        int[] answer;
        int c = arr[0];
        for (int d : arr) {
            if (d < c) {
                c = d;
            }
        }
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            a.add(String.valueOf(arr[i]));
        }
        if (a.size()==1){
            a.remove(0);
            a.add(String.valueOf(-1));
        }else {
            a.remove(String.valueOf(c));
        }
        String[] b = a.toArray(new String[0]);
        answer=Arrays.stream(b).mapToInt(Integer::valueOf).toArray();
        return answer;
    }
}

public class Num10 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        int[] answer;
        int c = arr[0];
        for (int d : arr) {
            if (d < c) {
                c = d;
            }
        }
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            a.add(String.valueOf(arr[i]));
        }
        System.out.println(c);
        if (a.size()==1){
            a.remove(0);
            a.add(String.valueOf(-1));
        }else {
            a.remove(String.valueOf(c));
        }
        String[] b = a.toArray(new String[0]);
        answer=Arrays.stream(b).mapToInt(Integer::valueOf).toArray();

//        Arrays.sort(arr);
//        String[] a = Arrays.stream(arr)
//                .mapToObj(String::valueOf)
//                .toArray(String[]::new);
//        ArrayList<String> b = new ArrayList<>(List.of(a));
//
//        b.remove(0);
//        b.sort(Collections.reverseOrder());
//        System.out.println(b);
//        if (b.size() == 0) {
//            b.add("-1");
//            String[] c = b.toArray(new String[0]);
//            int[] answer = Arrays.stream(c)
//                    .mapToInt(Integer::valueOf)
//                    .toArray();
//        } else {
//            String[] c = b.toArray(new String[0]);
//            int[] answer = Arrays.stream(c)
//                    .mapToInt(Integer::valueOf)
//                    .toArray();
//        }

//

        for (int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }

    }

}
