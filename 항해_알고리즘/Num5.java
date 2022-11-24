package 항해_알고리즘;

import java.util.ArrayList;
class Solution5 {
    public String solution(String s) {
        String answer = "";
        String[] result=s.split(" ",-1);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            String a1 = "";
            for (int j = 0; j < result[i].length(); j++) {
                if (j % 2 == 0) {
                    String d = String.valueOf(result[i].charAt(j));
                    a1 += d.toUpperCase();
                } else {
                    String b = String.valueOf(result[i].charAt(j));
                    a1 += b.toLowerCase();
                }

            }
            list.add(a1);
        }
        answer = String.join(" ", list);
        return answer;
    }
}

public class Num5 {
    public static void main(String[] args) {
        String answer = "";
        String s = " try  hello   world  ";
        String[] result=s.split(" ",-1);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            String a1 = "";
            for (int j = 0; j < result[i].length(); j++) {
                if (j % 2 == 0) {
                    String d = String.valueOf(result[i].charAt(j));
                    a1 += d.toUpperCase();
                } else {
                    String b = String.valueOf(result[i].charAt(j));
                    a1 += b.toLowerCase();
                }

            }
            list.add(a1);
        }
        System.out.println(list);
        answer = String.join(" ", list);
        System.out.println(answer);
    }
}
