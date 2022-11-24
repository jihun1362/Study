package 항해_알고리즘;

import java.util.ArrayList;

class Solution35 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        return answer;
    }
}

public class Num35 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] answer = new String[n];
        ArrayList<String> arrayList = new ArrayList<>();
        String[] arr1Binary1 = new String[n];
        String[] arr1Binary2 = new String[n];

        //arr1 - 2진수 변환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(String.valueOf(arr1[i] % 2));
                arr1[i] = arr1[i] / 2;
            }
            arr1Binary1[i] = String.join("", arrayList);
            arrayList.clear();
            String reverse = "";
            for (int k = arr1Binary1[i].length() - 1; k >= 0; k--) {
                reverse = reverse + arr1Binary1[i].charAt(k);
            }
            arr1Binary1[i] = reverse;
        }

        //체크
//        for (String i : arr1Binary1) {
//            System.out.println(i);
//        }

        //arr1 - 2진수 변환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(String.valueOf(arr2[i] % 2));
                arr2[i] = arr2[i] / 2;
            }
            arr1Binary2[i] = String.join("", arrayList);
            arrayList.clear();
            String reverse = "";
            for (int k = arr1Binary2[i].length() - 1; k >= 0; k--) {
                reverse = reverse + arr1Binary2[i].charAt(k);
            }
            arr1Binary2[i] = reverse;
        }

        //체크
//        for (String i : arr1Binary2) {
//            System.out.println(i);
//        }

        //중복 부분 1로 바꾸기
        ArrayList<String> join = new ArrayList<>();
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            String[] Binary1 = arr1Binary1[i].split("");
            String[] Binary2 = arr1Binary2[i].split("");
            for (int j = 0; j < n; j++) {
                if (Binary1[j].equals("1") || Binary2[j].equals("1")) {
                    join.add("1");
                } else {
                    join.add("0");
                }
            }
            result[i] = String.join("", join);
            join.clear();
        }

        //"#"," "로 변환
        for (int i = 0; i < n; i++) {
            answer[i] = result[i].replaceAll("1","#").replaceAll("0"," ");
        }

        // 체크
        for (String i : answer) {
            System.out.println(i);
        }


    }
}
