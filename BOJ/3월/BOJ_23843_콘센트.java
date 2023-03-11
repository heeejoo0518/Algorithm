import java.io.*;
import java.util.*;

public class BOJ_23843_콘센트 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//배열 정렬한다
		int[] charge = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) charge[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(charge);

		//queue 사이즈=최대 M, 그 요소는 누적합
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=N-1;i>=0;i--){
			if(queue.size()<M) queue.offer(charge[i]);
			else queue.offer(queue.poll()+charge[i]);
		}

		//하나빼고 전부 뽑기
		int size = queue.size();
		while(--size>0) queue.poll();

		//출력
		System.out.println(queue.poll());
	}
}
