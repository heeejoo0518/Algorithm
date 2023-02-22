import java.io.*;
import java.util.*;

public class BOJ_1713_후보추천하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		int[] index = new int[101];
		int[] count = new int[101];

		//0 : 학생번호, 1:인덱스(처음 걸린 순서)
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
			if(count[o1]!=count[o2]) return count[o1]-count[o2];
			else return index[o1]-index[o2];});

		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++){
			int num = Integer.parseInt(st.nextToken());
			count[num]++;

			//이미 있다면
			if(queue.contains(num)){
				queue.remove(num);
				queue.add(num);
				continue;
			}

			//빈자리 없을 때
			if(queue.size()>=N) {
				count[queue.poll()] = 0;
			}

			//삽입
			index[num] = i;
			queue.add(num);
		}

		int[] answer = new int[queue.size()];
		for(int i=0;i<answer.length;i++) answer[i] = queue.poll();
		Arrays.sort(answer);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<answer.length;i++) sb.append(answer[i]).append(' ');

		System.out.print(sb);
	}
}
