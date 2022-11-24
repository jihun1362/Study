package 항해_알고리즘;

import java.util.*;

class Solution4 extends Thread{
    public String solution(String[] participant, String[] completion) {
        String answer;
        ArrayList<String> s1 = new ArrayList<>(Arrays.asList(participant));
        HashSet<String> s2 = new HashSet<>(Arrays.asList(completion));

        s1.removeAll(s2);

        if (s1.size() == 0) {
            Arrays.sort(participant);
            Arrays.sort(completion);
            for(int i=0;i<completion.length;i++) {
                if (!participant[i].equals(completion[i])) {
                    answer = participant[i];
                    return answer;
                }
            }
        }

        answer=s1.toArray(new String[0])[0];
        return answer;
    }
}

public class Num4 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String answer;

        ArrayList<String> s1 = new ArrayList<>(Arrays.asList(participant));
        HashSet<String> s2 = new HashSet<>(Arrays.asList(completion));

        HashSet<String> subtract = new HashSet<>(s1);

        subtract.removeAll(s2);

        System.out.println(subtract);

        if (s1.size() == 0) {
            Arrays.sort(participant);
            Arrays.sort(completion);
            for(int i=0;i<completion.length;i++) {
                if (!participant[i].equals(completion[i])) {
                    answer = participant[i];
                    System.out.println(answer);
                    break;
                }
            }
        }

        answer=subtract.toArray(new String[0])[0];
        System.out.println(answer);






//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]);
//        }
    }
}
