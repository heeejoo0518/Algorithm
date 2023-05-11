import java.util.*;

class Solution {
    int[][] board;
    int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[] solution(int rows, int columns, int[][] queries) {
        board = new int[rows+1][columns+1];        
        for(int i=1, num = 1;i<=r;i++){
            for(int j=1;j<=c;j++){
                board[i][j] = num++;
            }
        }
        
        int[] answer = new int[queries.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    public int rotate(int[] query){
        int x = query[0];
        int y = query[1];
        int prev = board[x][y];
        int min = prev;
        
        int gap, tmp;
        for(int d=0;d<4;d++){
            gap = d%2==0?query[3]-query[1]:query[2]-query[0];
            for(int i=0;i<gap;i++){
                x += deltas[d][0];
                y += deltas[d][1];
                
                tmp = prev;
                prev = board[x][y];
                board[x][y] = tmp;
                
                min = Math.min(min,prev);
            }
        }
        
        return min;
    }
}
