import java.io.*;
import java.util.*;

public class BOJ_20304_비밀번호제작 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] result = new int[N+1];
		Arrays.fill(result,-1);
		Queue<Integer> queue = new ArrayDeque<>();

		int num, max = 0;
		for(int i=0;i<M;i++){
			num = Integer.parseInt(st.nextToken());
			queue.offer(num);
			result[num] = 0;
		}

		while(!queue.isEmpty()){
			num = queue.poll();
			if(max<result[num]) max = result[num];

			for(int i=0, next;i<20;i++){
				next = num^(1<<i);
				if(next > N || result[next]>-1) continue;
				result[next] = result[num]+1;
				queue.offer(next);
			}
		}

		System.out.println(max);
	}
}
