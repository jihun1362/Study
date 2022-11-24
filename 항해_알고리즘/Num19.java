package 항해_알고리즘;

import java.util.*;

class Solution19 {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        return answer;
    }
}

public class Num19 {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

//        Arrays.sort(strings);
//        TreeMap<String, String> stringsN = new TreeMap<>();
//        for (int i = 0; i < strings.length; i++) {
//            stringsN.put(strings[i].substring(n, n + 1) + i, strings[i]);
//        }
//        ArrayList<String> stringsNKey = new ArrayList<>(stringsN.keySet());
//
//
//        for (int i = 0; i < stringsN.size(); i++) {
//            answer[i] = stringsN.get(stringsNKey.get(i));
//        }
//
//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]);
//        }







        ArrayList<String> stringsN = new ArrayList<>();
        for (String i:strings){
            stringsN.add(i.charAt(n)+i);
        }
        Collections.sort(stringsN);
        String[] answer = new String[stringsN.size()];
        for (int i = 0; i < stringsN.size(); i++){
            answer[i] = stringsN.get(i).substring(1);
        }

    }
}
