import java.io.*;
import java.util.*;

public class BOJ_2161_카드1 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1;i<=N;i++){
			queue.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		while(queue.size()>1){
			sb.append(queue.poll()).append(' ');
			queue.offer(queue.poll());
		}
		sb.append(queue.poll());
		System.out.println(sb);
	}
}
