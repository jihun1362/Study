package 항해_알고리즘;

import java.util.ArrayList;

class Solution21 {
    public int solution(int[] nums) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}

public class Num21 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    numbers.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        System.out.println(numbers);
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : numbers) {
            int count=0;
            for (int j = 1; j < i; j++) {
                if (i%j==0) {
                    ++count;
                }
            }
            if (count==1) list.add(i);
        }
        System.out.println(list.size());
    }
}
