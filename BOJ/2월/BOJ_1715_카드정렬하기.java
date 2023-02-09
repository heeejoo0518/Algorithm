import java.io.*;
import java.util.*;

public class BOJ_1715_카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++){
			pq.offer(Integer.parseInt(in.readLine()));
		}

		int answer = 0;
		int tmp;
		while(pq.size()>1){
			tmp = pq.poll()+pq.poll();
			answer += tmp;
			pq.offer(tmp);
		}

		System.out.println(answer);
	}
}
