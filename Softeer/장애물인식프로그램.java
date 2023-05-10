import java.util.*;
import java.io.*;

public class Main
{
    static char[][] board;
    static int N;
    static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String args[]) throws Exception
    {
        //입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        board = new char[N][N];
        for(int i=0;i<N;i++){
            board[i] = in.readLine().toCharArray();
        }

        //탐색
        ArrayList<Integer> count = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]=='1'){
                    count.add(bfs(i,j));
                }
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        sb.append(count.size()).append('\n');
        Collections.sort(count);
        for(int cnt:count){
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    public static int bfs(int i, int j){
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        board[i][j] = '0';

        int[] now;
        int ni,nj;
        while(!queue.isEmpty()){
            count++;
            now = queue.poll();

            for(int[] d:deltas){
                ni = now[0] + d[0];
                nj = now[1] + d[1];
                if(isValid(ni,nj)){
                    queue.offer(new int[]{ni,nj});
                    board[ni][nj] = '0';
                }
            }
        }

        return count;
    }

    public static boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<N && j<N && board[i][j]=='1';
    }
}
