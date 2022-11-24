package 항해_알고리즘;

import java.util.Arrays;

class Solution27 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        return answer;
    }
}
public class Num27 {
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;


        Arrays.sort(d);
        int total=0;
        int department=0;
        for (int i=0; i<d.length;i++){
            total+=d[i];
            if (total>budget) {
                total-=d[i];
                break;
            }
            department+=1;
        }
        System.out.println(department);
    }
}
