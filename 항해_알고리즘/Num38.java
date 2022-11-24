package 항해_알고리즘;
class Solution38 {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        for(String i: arr){
            int num = Integer.parseInt(i);
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        String answer = Integer.toString(min) + " " + Integer.toString(max);
        return answer;
    }
}
public class Num38 {
}
