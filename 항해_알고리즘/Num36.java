package 항해_알고리즘;
import java.util.*;
class Solution36 {
    public String solution(int[] numbers, String hand) {
        int left = 10; //왼손 현재 위치, *은 10
        int right = 11; //오른손 현재 위치, #은 11
        StringBuilder answerSB = new StringBuilder();
        Map<Integer,int[]> map = new HashMap<>();
        int[][] arr= {
                {3,1,0,1,2,1,2,3,2,3,4,4}, //2번 키패드 0~#까지의 거리, 인덱스가 해당 번호를 나타냄. *은 10, #은 11
                {2,2,1,2,1,0,1,2,1,2,3,3}, //5번 키패드 0~#까지의 거리
                {1,3,2,3,2,1,2,1,0,1,2,2}, //8번 키패드 0~#까지의 거리
                {0,4,3,4,3,2,3,2,1,2,1,1}  //0번 키패드 0~#까지의 거리
        };
        map.put(2,arr[0]);
        map.put(5,arr[1]);
        map.put(8,arr[2]);
        map.put(0,arr[3]);


        for(int i : numbers){
            if(i==1 || i==4 || i==7){
                left = i;
                answerSB.append("L");
            }
            else if(i==3 || i==6 || i==9){
                right = i;
                answerSB.append("R");
            }
            else if(i==2 || i==5 || i==8 || i==0){
                int distanceL = map.get(i)[left]; //왼손과 눌러야 할 키패드 사이의 거리
                int distanceR = map.get(i)[right];  // 오른손과 눌러야 할 키패드 사이의 거리
                if(distanceL<distanceR){
                    left = i;
                    answerSB.append("L");
                }
                else if(distanceL>distanceR){
                    right = i;
                    answerSB.append("R");
                }
                else if(distanceL==distanceR && hand.equals("left")){
                    left = i;
                    answerSB.append("L");
                }
                else if(distanceL==distanceR && hand.equals("right")){
                    right = i;
                    answerSB.append("R");
                }
            }
        }

        String answer = answerSB.toString();

        return answer;
    }
}
public class Num36 {
}
