import java.io.*;
import java.util.*;

public class BOJ_14003_가장긴증가하는부분수열5 {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
      StringTokenizer st = new StringTokenizer(in.readLine());

      ArrayList<Integer> list = new ArrayList<>();
      int[] array = new int[N];
      int[] index = new int[N];

      int num, idx;
      for(int i=0;i<N;i++){
         num = Integer.parseInt(st.nextToken());
         array[i] = num;

         idx = Collections.binarySearch(list, num);
         if(idx < 0) idx = -idx-1;

         if(idx == list.size()) list.add(num);
         else list.set(idx,num);

         index[i] = idx;
      }

      StringBuilder sb = new StringBuilder();
      sb.append(list.size()).append('\n');

      Stack<Integer> stack = new Stack<>();
      idx = list.size()-1;
      for(int i=N-1;i>=0;i--){
         if(index[i] != idx) continue;
         stack.push(array[i]);
         --idx;
      }

      while(!stack.empty()) sb.append(stack.pop()).append(' ');
      System.out.println(sb);
   }
}
