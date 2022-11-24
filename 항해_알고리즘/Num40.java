package 항해_알고리즘;
import java.util.*;

import java.util.*;

class Solution40 {
    public int solution(int[][] board, int[] moves) {
        
        // n x n 배열 
        int boardLength = board.length;
        
        
        // 바구니 
        ArrayList<Integer> answer = new ArrayList<>();
        
        
        // 왼쪽 바구니의 인형이 있는 칸을 저장하는 counts배열 
        int[] counts = new int[boardLength + 1];

        
        // 주어진 배열 for문
        for(int i=0; i < moves.length; i++){
            
            // 왼쪽 바구니 위치 (0 ~ n)
            int target = moves[i];
            
            for(int j= counts[target]; j< board.length; j++){
        
                // 값이 0인 경우 
                if(board[j][target-1] == 0){
                    counts[target] += 1;
                    continue;
                }
                
                // 오른쪽 바구니에 저장
                answer.add(board[j][target -1]);
                counts[target] += 1;
                break;
               
            }
        }

        // 결과 바구니에서 중복 값 삭제 
        int result = 0;
        for(int i=0; i < answer.size() -1; ){
            if(answer.get(i).equals(answer.get(i+1))){
                
                result += 2;
                answer.remove(i+1);
                answer.remove(i);
                i=0;
            }else {
                i += 1;
            }
        }
 
        return result;
    }
}
public class Num40 {
}
