package 항해_알고리즘;
class Solution37 {
    public int solution(String dartResult) {
        int answer = 0;
        int [] score = new int[3];

        String answerlist = "";
        int number = 0;
        int index = 0;

        for(int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);

            //숫자일 경우
            if(c >= '0' && c <='9'){
                answerlist += String.valueOf(c);
            }//보너스 점수 계산
            else if(c =='S' || c == 'D' || c == 'T'){
                number = Integer.parseInt(answerlist);
                if(c == 'S'){
                    score[index] = (int)Math.pow(number,1);
                    index++;
                } else if(c == 'D'){
                    score[index] = (int)Math.pow(number,2);
                    index++;
                } else{
                    score[index] = (int)Math.pow(number,3);
                    index++;
                }
                //문자열 리셋을 해서 다음 다트 점수 계산을 시작한다.
                answerlist="";
            } else{
                if(c == '*'){
                    //보너스 점수를 계산하면 index가 값이 오른다.
                    score[index - 1] = score[index -1] * 2;
                    if(index >= 2){
                        score[index-2] = score[index-2] * 2;
                    }
                } else if(c == '#'){
                    score[index-1] = -score[index-1];
                }
            }
        }

        for(int i = 0; i < score.length; i++){
            answer += score[i];
        }
        return answer;
    }
}
public class Num37 {
}
