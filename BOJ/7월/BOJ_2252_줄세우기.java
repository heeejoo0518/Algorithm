import java.io.*;
import java.util.*;

public class BOJ_2252_줄세우기 {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int[] count = new int[N+1];
      ArrayList<Integer>[] students = new ArrayList[N+1];
      for(int i=1;i<=N;i++) students[i] = new ArrayList<>();
      int a, b;
      for(int i=0;i<M;i++){
         st = new StringTokenizer(in.readLine());
         a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());
         ++count[b];
         students[a].add(b);
      }

      Queue<Integer> queue = new ArrayDeque<>();
      for(int i=1;i<=N;i++) {
         if(count[i]==0) queue.offer(i);
      }

      StringBuilder sb = new StringBuilder();
      int now;
      while(!queue.isEmpty()){
         now = queue.poll();
         sb.append(now).append(' ');

         for(int n:students[now]){
            if(--count[n]==0) queue.offer(n);
         }
      }

      System.out.println(sb);
   }
}
