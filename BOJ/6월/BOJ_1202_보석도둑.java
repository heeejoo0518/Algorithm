import java.io.*;
import java.util.*;

public class BOJ_1202_보석도둑 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<int[]> jewel = new ArrayList<>();
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			jewel.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		Collections.sort(jewel,(o1, o2) -> o1[0]-o2[0]);

		int[] backpack = new int[K];
		for(int i=0;i<K;i++) backpack[i] = Integer.parseInt(in.readLine());
		Arrays.sort(backpack);

		long answer = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
		int last = 0;
		for(int i=0;i<K;i++){
			while(last < N && backpack[i] >= jewel.get(last)[0]){
				pq.offer(jewel.get(last++));
			}
			if(!pq.isEmpty()) answer += pq.poll()[1];
		}

		System.out.println(answer);
	}
}
