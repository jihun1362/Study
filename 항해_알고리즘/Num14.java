package 항해_알고리즘;

class Solution14 {
    public int solution(int[][] sizes) {
        int bigsize = 0;
        int smallsize=0;

        for (int[] size:sizes){
            bigsize = Math.max(bigsize,Math.max(size[0],size[1]));
            smallsize = Math.max(smallsize,Math.min(size[0],size[1]));
        }

        int answer= bigsize*smallsize;

        return answer= bigsize*smallsize;
    }
}
public class Num14 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int bigsize = 0;
        int smallsize=0;

        for (int[] size:sizes){
            bigsize = Math.max(bigsize,Math.max(size[0],size[1]));
            smallsize = Math.max(smallsize,Math.min(size[0],size[1]));
        }

        int answer= bigsize*smallsize;

    }
}
