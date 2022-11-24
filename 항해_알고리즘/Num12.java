package 항해_알고리즘;


class Solution12 {
    public boolean solution(int x) {
        boolean answer;
        String[] a = String.valueOf(x).split("");
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum += Integer.parseInt(a[i]);
        }
        if (x%sum==0)
            answer=true;
        else
            answer=false;
        return answer;
    }
}
/*x=12면
조건 - 1+2=3 -> 숫자를 하나씩 분리
조건2 - 12/3
조건3 = x=true;
* */
public class Num12 {
    public static void main(String[] args) {
        int x = 12;
        boolean answer;

        String[] a = String.valueOf(x).split("");

        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum += Integer.parseInt(a[i]);
        }

        if (x%sum==0)
            answer=true;
        else
            answer=false;
        System.out.println(answer);

    }
}
