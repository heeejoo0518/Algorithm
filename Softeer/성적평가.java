import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        Score[] total = new Score[N];
        for(int i=0;i<N;i++) total[i] = new Score(i,0);

        Score[] current = new Score[N];
        
        for(int i=0;i<3;i++){
            st = new StringTokenizer(in.readLine());
            
            //입력
            for(int j=0;j<N;j++){
               current[j] = new Score(j,Integer.parseInt(st.nextToken()));
               total[j].score+=current[j].score;
            }
            //정렬
            Arrays.sort(current);

            //순위
            int[] tmp = setOrder(current);

            //출력
            for(int j=0;j<N;j++){
                sb.append(tmp[j]).append(' ');
            }
            sb.append('\n');
        }

        //전체점수 정렬 및 순위출력
        Arrays.sort(total);
        int[] tmp = setOrder(total);
        for(int j=0;j<N;j++){
            sb.append(tmp[j]).append(' ');
        }

        System.out.println(sb);
    }

    public static int[] setOrder(Score[] current){
        int[] tmp = new int[N];
        int order = 1;
        tmp[current[0].idx] = order;
        for(int j=1;j<N;j++){
            if(current[j-1].score != current[j].score){
                order = j+1;
            }
            tmp[current[j].idx] = order;
        }
        return tmp;
    }

    static class Score implements Comparable<Score> {
        int idx;
        int score;
        public Score(int idx, int score){
            this.idx = idx;
            this.score = score;
        }
        public int compareTo(Score o){
            return o.score-this.score;
        }
    
    }
}
