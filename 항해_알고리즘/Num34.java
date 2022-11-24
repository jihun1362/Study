package 항해_알고리즘;

import java.util.HashSet;

class Solution34 {
    public int solution(int[] nums) {
        int answer = 0;
        return answer;
    }
}
public class Num34 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int answer = 0;
        //중복되지 않는 포켓몬의 개수 구하기
        HashSet<Integer> numslist=new HashSet<>();
        for (int i:nums){
            numslist.add(i);
        }
        int count1=numslist.size();
        //배열의 절반 값 구하기
        int count2=nums.length/2;
        //최소값 리턴
        answer+=Math.min(count1,count2);
        System.out.println(answer);
    }
}
