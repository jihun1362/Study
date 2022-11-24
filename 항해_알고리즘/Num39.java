package 항해_알고리즘;

import java.util.ArrayList;

class Solution39 {
    public int solution(int n) {
        int answer = 0;
        return answer;
    }
}

public class Num39 {
    public static void main(String[] args) {
        int n = 3;

        int answer = 0;

        int nCount = 0;
        int count=0;
        int i=1;
        while (true){
            System.out.println(i);
            nCount+=i;
            if (nCount==n){
                answer+=1;
                count+=1;
                i=1+count;
            }else if (nCount > n){
                nCount=0;
                count+=1;
                i=1+count;
            }else i++;
            if (count==n)break;
        }



//        ArrayList<Integer> nArray=new ArrayList<>();
//        for (int i = 0; i < n; i++){
//            nArray.add(i+1);
//        }
//        int nCount = 0;
//        int count=1;
//        for (int i = count; i <= n; i++) {
//            if (count==n)break;
//
//            if (nCount == n) {
//                nCount = 0;
////                nArray.remove(0);
//                count++;
//                ++answer;
//                i = 0;
//            } else if (nCount > n) {
//                count++;
//                nCount = 0;
////                nArray.remove(0);
//                i = 0;
//            }
////            nCount += nArray.get(i);
//            nCount += i;
//        }
        System.out.println(answer);
    }
}
