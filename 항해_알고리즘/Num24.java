package 항해_알고리즘;

import java.util.ArrayList;

class Solution24 {
    public String solution(String new_id) {
        String answer = "";
        return answer;
    }
}

public class Num24 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm.";

        String answer = "";
        //1단계 - new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
        //2단계 - new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = new_id.replaceAll("[^\\w\\-_.]*", "");
        //3단계 - new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = new_id.replaceAll("\\.{2,}",".");
        //4단계 - new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        new_id = new_id.replaceAll("^\\.|\\.$","");
        //5단계 - new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        new_id = new_id.length() == 0 ? "a" : new_id;
        //6단계 - new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (16 <= new_id.length()) new_id = new_id.substring(0, 15).replaceAll("^\\.|\\.$", "");
        //7단계 - new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (new_id.length()<2) new_id += new_id.charAt(0);
        if (new_id.length()<=2) new_id += new_id.charAt(1);
        System.out.println(new_id);

//        //1단계
//        new_id = new_id.toLowerCase();
//        //2단계
//        ArrayList<Character> arrayList = new ArrayList<>();
//        for (int i = 0; i < new_id.length(); i++) {
//            arrayList.add(new_id.charAt(i));
//        }
//        for (int i = 0; i < arrayList.size(); i++) {
//            if (arrayList.get(i) == 46 || arrayList.get(i) == 45 || arrayList.get(i) == 95) {
//            } else if (arrayList.get(i) > 47 && arrayList.get(i) < 57) {
//            } else if (arrayList.get(i) > 96 && arrayList.get(i) < 123) {
//            } else {
//                arrayList.remove(arrayList.get(i));
//                i--;
//            }
//        }
//        System.out.println(arrayList);
//        //3단계
//        ArrayList<Character> arrayList2 = new ArrayList<>();
//        char idPart='.';
//        for (char i:arrayList) {
//            if (i==46) {
//                if (idPart == i) {
//                }else {
//                    arrayList2.add(i);
//                }
//            }else {
//                arrayList2.add(i);
//            }
//            idPart=i;
//        }
//        System.out.println(arrayList2);
//
//        //5단계
//        if (arrayList2.size()==0) arrayList2.add('a');
//        //4단계
//        if (arrayList2.get(arrayList2.size()-1)==46) arrayList2.remove(arrayList2.size()-1);
//        //6단계
//        if (arrayList2.size()>15){
//            for (int i=15;i<arrayList2.size();i++) {
//                arrayList2.remove(i);
//                i--;
//            }
//        }
//        //4단계
//        if (arrayList2.get(arrayList2.size()-1)==46) arrayList2.remove(arrayList2.size()-1);
//        //7단계
//        if (arrayList2.size()<2) arrayList2.add(arrayList2.get(arrayList2.size()-1));
//        if (arrayList2.size()<=2) arrayList2.add(arrayList2.get(arrayList2.size()-1));
//
//        for (char i:arrayList2){
//            answer += i;
//        }


        System.out.println(answer);
    }
}
