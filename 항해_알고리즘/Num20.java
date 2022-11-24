package 항해_알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution20 {
    public String solution(String s) {
        String answer = "";

        return answer;
    }
}

public class Num20 {
    public static void main(String[] args) {
        String s="Zbcdefg";

        String[] strings = s.split("");
        Arrays.sort(strings, Comparator.reverseOrder());
        ArrayList<String> strings1 =new ArrayList<>(List.of(strings));
        String answer = String.join("",strings1);


    }
}
