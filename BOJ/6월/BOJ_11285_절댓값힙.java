import java.io.*;
import java.util.*;

public class BOJ_11285_절댓값힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			if(Math.abs(o1)!=Math.abs(o2)) return Math.abs(o1)-Math.abs(o2);
			else return o1-o2;
		});
		StringBuilder sb = new StringBuilder();
		int num;
		for(int i=0;i<N;i++){
			num = Integer.parseInt(in.readLine());
			if(num!=0) pq.offer(num);
			else if(pq.isEmpty()) sb.append("0\n");
			else sb.append(pq.poll()).append('\n');
		}

		System.out.print(sb);
	}
}
