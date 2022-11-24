package 항해_알고리즘;

import java.util.ArrayList;

class Solution33 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }

        for (int i : lost) {
            result[i - 1] = 0;
        }

        ArrayList<Integer> lostlist =new ArrayList<>();
        for (int i=0; i< lost.length;i++){
            lostlist.add(lost[i]);
        }
        ArrayList<Integer> reservelist =new ArrayList<>();
        for (int i=0; i< reserve.length;i++){
            reservelist.add(reserve[i]);
        }
        ArrayList<Integer> retain =new ArrayList<>(lostlist);
        retain.retainAll(reservelist);
        for (int i : retain){
            result[i - 1] = 1;
        }

        ArrayList<Integer> reserveListFinal =new ArrayList<>(reservelist);
        reserveListFinal.removeAll(retain);
        System.out.println(reserveListFinal);
        for (int i : reserveListFinal) {
            if (i == 1) {
                if (result[i] == 0) result[i] = 1;
            } else if (i == n) {
                if (result[i - 2] == 0) result[i - 2] = 1;
            } else {
                if (result[i - 2] == 0) result[i-2] = 1;
                else if (result[i] == 0) result[i] = 1;
            }
        }

        int count=0;
        for (int i = 0; i < result.length; i++) {
            if (result[i]==1)count++;
        }

        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        for (int i : lost) {
            result[i - 1] = 0;
        }

        for (int i : reserveListFinal) {
            if (i == 1) {
                if (result[i] == 0) result[i] = 1;
            } else if (i == n) {
                if (result[i - 2] == 0) result[i - 2] = 1;
            } else {
                if (result[i] == 0) result[i] = 1;
                else if (result[i - 2] == 0) result[i - 2] = 1;
            }
        }

        int count2=0;
        for (int i = 0; i < result.length; i++) {
            if (result[i]==1)count2++;
        }

        answer+=Math.max(count,count2);
        return answer;
    }
}

public class Num33 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};

        int answer = 0;
        int loopCount = 0;
        int count = 0;
        int count2 = 0;
        while (true) {
            //체육복을 가고있는 사람
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = 1;
            }

            //체육복을 가지고 있는 사람에서 잃어버린 사람을 빼줌
            for (int i : lost) {
                result[i - 1] = 0;
            }

            //체육복을 잃어버렸지만 여유분을 가지고있는 사람 제외
            ArrayList<Integer> lostlist = new ArrayList<>();
            for (int i = 0; i < lost.length; i++) {
                lostlist.add(lost[i]);
            }
            ArrayList<Integer> reservelist = new ArrayList<>();
            for (int i = 0; i < reserve.length; i++) {
                reservelist.add(reserve[i]);
            }
            ArrayList<Integer> retain = new ArrayList<>(lostlist);
            retain.retainAll(reservelist);
            for (int i : retain) {
                result[i - 1] = 1;
            }

            //체육복을 안잃어버리고 여유분이 있는 사람
            ArrayList<Integer> reserveListFinal = new ArrayList<>(reservelist);
            reserveListFinal.removeAll(retain);
            //빌려줄 수 있는 경우의 수
            for (int i : reserveListFinal) {
                if (i == 1) {
                    if (result[i] == 0) result[i] = 1;
                } else if (i == n) {
                    if (result[i - 2] == 0) result[i - 2] = 1;
                } else {
                    if (loopCount == 0) {
                        if (result[i] == 0) result[i] = 1;
                        else if (result[i - 2] == 0) result[i - 2] = 1;
                    } else {
                        if (result[i - 2] == 0) result[i - 2] = 1;
                        else if (result[i] == 0) result[i] = 1;
                    }
                }
            }

            //첫번째 경우의 수와 두번째 경우의수 저장
            for (int i = 0; i < result.length; i++) {
                if (loopCount == 0) {
                    if (result[i] == 1) count++;
                }else
                    if (result[i] == 1) count2++;
            }
            if (loopCount==1)break;
            loopCount+=1;
        }
        //경우의 수 중 큰값 리턴
        answer += Math.max(count, count2);

//        for (int i = 0; i < n; i++) {
//            result[i] = 1;
//        }
//        for (int i : lost) {
//            result[i - 1] = 0;
//        }
//
//        for (int i : reserveListFinal) {
//            if (i == 1) {
//                if (result[i] == 0) result[i] = 1;
//            } else if (i == n) {
//                if (result[i - 2] == 0) result[i - 2] = 1;
//            } else {
//                if (loopcount==0) {
//                    if (result[i] == 0) result[i] = 1;
//                    else if (result[i - 2] == 0) result[i - 2] = 1;
//                }else {
//                    if (result[i] == 0) result[i] = 1;
//                    else if (result[i - 2] == 0) result[i - 2] = 1;
//                }
//            }
//        }
//
//        int count2=0;
//        for (int i = 0; i < result.length; i++) {
//            if (result[i]==1)count2++;
//        }


        System.out.println(answer);
    }
}
