import java.io.*;
import java.util.*;

public class BOJ_15903_카드합체놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> queue = new PriorityQueue<>();
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) queue.offer(Long.parseLong(st.nextToken()));

		long sum;
		for(int i=0;i<M;i++){
			sum = queue.poll()+ queue.poll();
			queue.offer(sum);
			queue.offer(sum);
		}

		long result = 0;
		while(!queue.isEmpty()){
			result += queue.poll();
		}

		System.out.println(result);
	}
}
