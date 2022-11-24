package 항해_알고리즘;

import java.util.*;

class Solution32 {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        return answer;
    }
}

public class Num32 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        //배열N까지 선언
        int[] answer = new int[N];
        double[] result = new double[N];

        //answer배열에 스테이지 부여 N=5일 때 1,2,3,4,5
        for (int i = 0; i < N; i++) {
            answer[i] = i + 1;
        }

        //실패율 계산
        int fail = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i + 1 == stages[j]) ++count;
            }
            result[i] = ((double) count / (stages.length - fail));
            fail += count;
        }

        //체크 answer={1, 2, 3, 4, 5}
        //result={0.125, 0.42857142857142855, 0.5, 0.5, 0}
        for (int i = 0; i < answer.length; i++)
            System.out.println(answer[i]);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);

        //정렬삽입
        for (int i = N - 1; i >= 1; i--) {
            for (int j = N - 1; j >= (N - i); j--) {
                if (result[j - 1] < result[j]) {
                    //실패율 크기 정렬
                    double failPersent = result[j - 1];
                    result[j - 1] = result[j];
                    result[j] = failPersent;
                    //실패율 크기가 정렬될 때 같이 정렬
                    int answerSort = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = answerSort;
                }
            }
        }

//        HashMap<Integer, Double> stageFailResult = new HashMap<>();
//        for (int i = 0; i < stageFailPersent.size(); i++) {
//            stageFailResult.put(i + 1, stageFailPersent.get(i));
//        }
//        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(stageFailResult.entrySet());
//        entryList.sort(Map.Entry.comparingByValue());
//        for(Map.Entry<Integer, Double> entry : entryList){
//            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
//        }
//        System.out.println(entryList);
//
////        ArrayList<String> keyList = new ArrayList<>(stageFailResult.keySet());
////        int j=stageFailResult.size()-1;
//        answer=new int[stageFailResult.size()];
//        double count=1;
//        int idx=0;
//        for(Map.Entry<Integer, Double> entry : entryList){
//           if (entry.getValue()==entry.getValue()){
//               answer[idx]=answer[idx-1];
//               answer[idx-1]=entry.getKey();
//           }else {
//               answer[idx]=entry.getKey();
//           }
//            idx++;
//            count=entry.getValue();
//        }
        for (int i = 0; i < answer.length; i++)
            System.out.println(answer[i]);
    }
}
