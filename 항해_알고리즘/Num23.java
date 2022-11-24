package 항해_알고리즘;

import java.util.ArrayList;

class Solution23 {
    public String solution(String s, int n) {
        String answer = "";
        return answer;
    }
}

public class Num23 {
    public static void main(String[] args) {
        String s = "p z P Z";
        int n = 15;

        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] + n < 123 && chars[i] > 96) {
                System.out.println(chars[i] + 1);
                if (chars[i] + n > 122) {
                    arrayList.add((char) (chars[i] + n - 26));
                } else {
                    arrayList.add((char) (chars[i] + n));
                }
            } else if (chars[i] == 32) {
                arrayList.add(chars[i]);
            } else {
                if (chars[i] + n > 90) {
                    arrayList.add((char) (chars[i] + n - 26));
                } else {
                    arrayList.add((char) (chars[i] + n));
                }
            }
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (Character i : arrayList) {
            arrayList2.add(String.valueOf(i));
        }

        String answer = String.join("", arrayList2);

        System.out.println(answer);
    }
}
